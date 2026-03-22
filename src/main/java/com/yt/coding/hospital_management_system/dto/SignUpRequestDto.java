package com.yt.coding.hospital_management_system.dto;

import java.util.HashSet;
import java.util.Set;

import com.yt.coding.hospital_management_system.entity.type.RoleType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {
    private String username;
    private String password;
    private String name;

    private Set<RoleType> roles = new HashSet<>();
}
