package com.yt.coding.hospital_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yt.coding.hospital_management_system.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    
}
