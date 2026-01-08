package org.example.module3.layered.service;

import org.example.module3.layered.dto.CarDto;
import org.example.module3.layered.exception.CarErrorEnum;
import org.example.module3.layered.exception.CarException;
import org.example.module3.layered.model.CarEntity;
import org.example.module3.layered.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    public final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public List<CarDto> getCars() {
        return carRepository
                .getCars()
                .stream()
                .map(carEntity -> new CarDto(carEntity.getName(),carEntity.getSpeed(), carEntity.getColor(), carEntity.getId()))
                .toList();
    }

    @Override
    public CarDto getCarById(int id) {
        CarEntity car = carRepository.getCarById(id).orElseThrow(()-> new CarException(CarErrorEnum.CAR_NOT_FOUND));
        return new CarDto(car.getName(), car.getSpeed(), car.getColor());
    }

    @Override
    public void addCar(CarDto carDto) {
        carRepository.saveCar(new CarEntity(carDto.name(),carDto.speed(),carDto.color()));
    }

    @Override
    public void updateCar(int id, CarDto carDto) {
        carRepository.updateCar(id, new CarEntity(carDto.name(),carDto.speed(),carDto.color()));
    }

    @Override
    public void deleteCarById(int id) {
        carRepository.deleteCarById(id);
    }
}
