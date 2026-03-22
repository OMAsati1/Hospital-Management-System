package com.yt.coding.hospital_management_system.service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.yt.coding.hospital_management_system.dto.AppointmentResponseDto;
import com.yt.coding.hospital_management_system.entity.Appointment;
import com.yt.coding.hospital_management_system.entity.Doctor;
import com.yt.coding.hospital_management_system.entity.Patient;
import com.yt.coding.hospital_management_system.repository.AppointmentRepository;
import com.yt.coding.hospital_management_system.repository.DoctorRepository;
import com.yt.coding.hospital_management_system.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Transactional
//     @Secured("ROLE_PATIENT") this will also create appointment for any patient but we want to restrict it to only the patient who is creating the appointment so we will use @PreAuthorize
        @PreAuthorize("hasRole('ADMIN') OR (hasRole('PATIENT') AND #patientId == authentication.principal.id)")
         public Appointment createAppointment(Appointment appointment,Long patientId, Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorId));
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId));

                if(appointment.getId() != null){
                    throw new RuntimeException("Appointment ID must be null for new appointments");
                }

                appointment.setDoctor(doctor);
                appointment.setPatient(patient);
                
                patient.getAppointments().add(appointment); // maintain bidirectional consistency
                
               return appointmentRepository.save(appointment);

            }

    @Transactional
    @PreAuthorize("hasAuthority('appointment:write') OR #doctorId == authentication.principal.id")
    public Appointment reAssigAppointmentToAnotherDoctor(Long appointmentId, Long newDoctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + appointmentId));
        Doctor newDoctor = doctorRepository.findById(newDoctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + newDoctorId));

        appointment.setDoctor(newDoctor);/* this will automatically update the foreign key column doctor_id in appointment 
        table because it is dirty side of the relationship */

        newDoctor.getAppointments().add(appointment); // maintain bidirectional consistency
        return appointment;
    }

    @PreAuthorize("hasRole('ADMIN') OR (hasRole('DOCTOR') AND #doctorId == authentication.principal.id)")        
     public List<AppointmentResponseDto> getAllAppointmentsOfDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        return doctor.getAppointments()
                .stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentResponseDto.class))
                .collect(Collectors.toList());
    }
 
}
