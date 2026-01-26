package org.example.module3.layered.service;
import org.example.module3.layered.dto.BrandDto;
import org.example.module3.layered.dto.CarDto;

import java.util.List;

public interface CarService {
    List<BrandDto> getBrands();

    BrandDto getBrandById(Integer id);

    void addBrand(BrandDto brandDto);
//
//    void updateCar(int id, CarDto carDto);
//
//    void deleteCarById(int id);
}
