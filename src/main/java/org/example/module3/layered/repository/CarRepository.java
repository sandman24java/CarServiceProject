package org.example.module3.layered.repository;

import org.example.module3.layered.model.BrandEntity;
import org.example.module3.layered.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity,Integer> {
}

