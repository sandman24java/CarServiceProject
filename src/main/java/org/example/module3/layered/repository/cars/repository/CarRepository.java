package org.example.module3.layered.repository.cars.repository;

import org.example.module3.layered.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity,Integer> {
}

