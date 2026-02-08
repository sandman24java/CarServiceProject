package org.example.carservice.repository.cars.repository;

import org.example.carservice.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity,Integer> {
}

