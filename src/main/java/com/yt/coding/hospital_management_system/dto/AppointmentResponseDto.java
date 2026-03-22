package com.yt.coding.hospital_management_system.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AppointmentResponseDto {
    private Long id;
    private LocalDateTime updatedAt;
    private String reason;
    private Long patientId;
    private String patientName;
}
