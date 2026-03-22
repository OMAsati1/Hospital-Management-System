package com.yt.coding.hospital_management_system.dto;

import java.time.LocalDate;

import com.yt.coding.hospital_management_system.entity.type.BloodGroupType;

import lombok.Data;

@Data
public class PatientResponseDto {
    private Long id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private BloodGroupType bloodGroup;
}
