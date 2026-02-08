package org.example.carservice.repository.auth.repository;

import org.example.carservice.model.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository
        extends JpaRepository<AppUserEntity, Long> {

    Optional<AppUserEntity> findByUsername(String username);
}