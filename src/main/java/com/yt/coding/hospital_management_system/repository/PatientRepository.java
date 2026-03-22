package com.yt.coding.hospital_management_system.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yt.coding.hospital_management_system.dto.BloodGroupCountResponseEntity;
import com.yt.coding.hospital_management_system.entity.Patient;
import com.yt.coding.hospital_management_system.entity.type.BloodGroupType;

import jakarta.transaction.Transactional;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    @Query("select p from Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate > :birthDate")    
    List<Patient> findByBornAfterDate(LocalDate birthDate);

    @Query("select new com.yt.coding.hospital_management_system.dto.BloodGroupCountResponseEntity (p.bloodGroup, count(p)) from Patient p group by p.bloodGroup")
    // List<Object[]> countEachBloodGroupType();
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Query("select p from Patient p")
    Page<Patient> findAllPatients(Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Patient p set p.name = :name where p.id = :id")
    int updateNameById(@Param("name") String name, @Param("id") Long id);

    // @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.doctor")
    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments")
    List<Patient> findAllPatientWithAppoinments();

}
