package org.example.module3.layered.service.car;

import org.example.module3.layered.dto.BrandDto;
import org.example.module3.layered.dto.CarDto;

import java.util.List;

public interface CarService {
    List<CarDto> getCars();

    CarDto getCarById(Integer id);

    void addCar(Integer modelId, CarDto carDto);

    void updateCar(Integer id, CarDto carDto);

    void deleteCarById(Integer id);
}
