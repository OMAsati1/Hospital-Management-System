package com.yt.coding.hospital_management_system.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yt.coding.hospital_management_system.dto.AppointmentResponseDto;
import com.yt.coding.hospital_management_system.entity.User;
import com.yt.coding.hospital_management_system.service.AppointmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentResponseDto>> getAllAppointmentsofDoctors(){

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 

        return ResponseEntity.ok(appointmentService.getAllAppointmentsOfDoctor(user.getId()));
    }
}



