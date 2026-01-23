package org.example.module3.layered.repository;

import org.example.module3.layered.model.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<BrandEntity,Long> {}

