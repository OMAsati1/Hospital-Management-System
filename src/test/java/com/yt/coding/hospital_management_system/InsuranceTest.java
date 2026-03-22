package com.yt.coding.hospital_management_system;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Qualifier;

import com.yt.coding.hospital_management_system.entity.Appointment;
import com.yt.coding.hospital_management_system.entity.Insurance;
import com.yt.coding.hospital_management_system.entity.Patient;
import com.yt.coding.hospital_management_system.service.AppointmentService;
import com.yt.coding.hospital_management_system.service.InsuranceService;
// import com.yt.coding.hospital_management_system.service.PatientService;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    @Qualifier("insuranceServiceImpl")
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance() {
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030, 12, 12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(patient);

        var newPatient = insuranceService.dissociateInsuranceFromPatient(patient.getId());
        System.out.println(newPatient);
    }

    @Test
    public void testCreateAppointment() {
        
          Appointment appointment = Appointment.builder()
          .updatedAt(LocalDateTime.of(2024, 7, 20, 10, 30))
          .reason("Cancer")
         .build();
          
          var newAppointment = appointmentService.createAppointment(appointment, 1L,
          1L);
          System.out.println(newAppointment);
          
         var updatedAppointment =
         appointmentService.reAssigAppointmentToAnotherDoctor(newAppointment.getId(),
         3L);
         System.out.println(updatedAppointment);
        
        /* Appointment apt1 = Appointment.builder()
                .updatedAt(LocalDateTime.of(2025, 7, 5, 8, 38))
                .reason("Asthma")
                .build();
        var appnt1 = appointmentService.createAppointment(apt1, 3L, 2L);

        Appointment apt2 = Appointment.builder()
                .updatedAt(LocalDateTime.of(2025, 5, 17, 4, 45))
                .reason("X-Ray")
                .build();
        var appnt2 = appointmentService.createAppointment(apt2, 3L, 2L);

        Appointment apt3 = Appointment.builder()
                .updatedAt(LocalDateTime.of(2026, 1, 5, 6, 20))
                .reason("ECG")
                .build();
        var appnt3 = appointmentService.createAppointment(apt3, 3L, 3L); */
    }

}