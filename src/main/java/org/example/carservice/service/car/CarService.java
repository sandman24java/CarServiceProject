package org.example.carservice.service.car;

import org.example.carservice.dto.cars.dto.CarDto;

import java.util.List;

public interface CarService {
    List<CarDto> getCars();

    CarDto getCarById(Integer id);

    void addCar(Integer modelId, CarDto carDto);

    void updateCar(Integer id, CarDto carDto);

    void deleteCarById(Integer id);
}
