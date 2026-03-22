package com.yt.coding.hospital_management_system.service;

import org.springframework.stereotype.Service;

import com.yt.coding.hospital_management_system.entity.Insurance;
import com.yt.coding.hospital_management_system.entity.Patient;
// import com.yt.coding.hospital_management_system.repository.InsuranceRepository;
import com.yt.coding.hospital_management_system.repository.PatientRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service("insuranceServiceImpl")
@RequiredArgsConstructor
public class InsuranceService {

    // private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); // bidirectional consistency maintainence

        return patient;
    }

    @Transactional
    public Patient dissociateInsuranceFromPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));
        patient.setInsurance(null);
        return patient;
    }
}