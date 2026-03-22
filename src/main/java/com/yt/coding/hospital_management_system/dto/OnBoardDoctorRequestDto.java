package com.yt.coding.hospital_management_system.dto;

import lombok.Data;

@Data
public class OnBoardDoctorRequestDto {
    private Long userId;
    private String specialization;
    private String name;
}
 