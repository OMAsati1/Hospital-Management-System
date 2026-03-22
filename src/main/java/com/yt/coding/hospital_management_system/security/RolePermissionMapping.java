package com.yt.coding.hospital_management_system.security;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.yt.coding.hospital_management_system.entity.type.PermissionType;
import com.yt.coding.hospital_management_system.entity.type.RoleType;

import static com.yt.coding.hospital_management_system.entity.type.PermissionType.*;
import static com.yt.coding.hospital_management_system.entity.type.RoleType.*;

public class RolePermissionMapping {
        private static final Map<RoleType, Set<PermissionType>> map = Map.of(
            PATIENT, Set.of(PATIENT_READ, APPOINTMENT_READ, APPOINTMENT_WRITE),
            DOCTOR, Set.of(APPOINTMENT_DELETE, APPOINTMENT_WRITE, APPOINTMENT_READ, PATIENT_READ),
            ADMIN, Set.of(PATIENT_READ, PATIENT_WRITE, APPOINTMENT_READ, APPOINTMENT_WRITE, APPOINTMENT_DELETE, USER_MANAGE, REPORT_VIEW)
    );

        public static Set<SimpleGrantedAuthority> getAuthoritiesByRole(RoleType role) {
            return map.get(role).stream()
                    .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                    .collect(Collectors.toSet());
        }
}
