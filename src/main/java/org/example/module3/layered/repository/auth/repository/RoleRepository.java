package org.example.module3.layered.repository.auth.repository;

import org.example.module3.layered.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    // Этот метод отличный, он поможет найти роль "USER" или "ADMIN" в базе
    Optional<RoleEntity> findByName(String name);
}