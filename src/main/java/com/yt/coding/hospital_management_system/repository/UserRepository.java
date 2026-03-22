package com.yt.coding.hospital_management_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yt.coding.hospital_management_system.entity.User;
import com.yt.coding.hospital_management_system.entity.type.AuthProviderType;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByProviderTypeAndProviderId(AuthProviderType providerType, String providerId);

}
