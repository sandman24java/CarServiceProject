package org.example.module3.layered.repository;

import org.example.module3.layered.model.BrandEntity;
import org.example.module3.layered.model.CarEntity;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    List<CarEntity> getBrands();

//    Optional<CarEntity> getCarById(int id);
//
    void addBrand(BrandEntity brandEntity);
//
//    void updateCar(int id, CarEntity carEntity);
//
//    void deleteCarById(int id);

}

