package com.yt.coding.hospital_management_system.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(length = 500)
    private String reason;

    @ManyToOne //owning side of the relationship
    @ToString.Exclude
    @JoinColumn(name = "patient_id", nullable = false) //patient_id is required and not nullable    
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY) //owning side of the relationship
    @JoinColumn(name = "doctor_id", nullable = false) //doctor_id is required and not nullable    
    private Doctor doctor;
}
