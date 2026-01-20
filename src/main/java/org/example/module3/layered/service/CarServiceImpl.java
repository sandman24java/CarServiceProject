package org.example.module3.layered.service;

import org.example.module3.layered.dto.BrandDto;
import org.example.module3.layered.dto.CarDto;
import org.example.module3.layered.exception.CarErrorEnum;
import org.example.module3.layered.exception.CarException;
import org.example.module3.layered.model.BrandEntity;
import org.example.module3.layered.model.CarEntity;
import org.example.module3.layered.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    public final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public List<BrandDto> getBrands() {
        return carRepository
                .getBrands()
                .stream()
                .map(brandEntity -> new BrandDto(brandEntity.getId(), brandEntity.getName(), brandEntity.getCountry(), brandEntity.getFoundedYear()))
                .toList();
    }


    //    @Override
//    public CarDto getCarById(int id) {
//        CarEntity car = carRepository.getCarById(id).orElseThrow(()-> new CarException(CarErrorEnum.CAR_NOT_FOUND));
//        return new CarDto(car.getName(), car.getSpeed(), car.getColor());
//    }
//
    @Override
    @Transactional(readOnly = true)
    public void addBrand(BrandDto brandDto) {
        carRepository.addBrand(new BrandEntity(brandDto.name(), brandDto.country(), brandDto.foundedYear()));
    }
}
//
//    @Override
//    public void updateCar(int id, CarDto carDto) {
//        carRepository.updateCar(id, new CarEntity(carDto.name(),carDto.speed(),carDto.color()));
//    }
//
//    @Override
//    public void deleteCarById(int id) {
//        carRepository.deleteCarById(id);
//    }
//}
