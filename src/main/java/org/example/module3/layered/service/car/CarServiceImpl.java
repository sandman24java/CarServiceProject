package org.example.module3.layered.service.car;

import org.example.module3.layered.dto.cars.dto.CarDto;
import org.example.module3.layered.exception.CarErrorEnum;
import org.example.module3.layered.exception.CarException;
import org.example.module3.layered.model.CarEntity;
import org.example.module3.layered.model.ModelEntity;
import org.example.module3.layered.repository.cars.repository.CarRepository;
import org.example.module3.layered.repository.cars.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;
    private final ModelRepository modelRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository,ModelRepository modelRepository){
        this.carRepository = carRepository;
        this.modelRepository = modelRepository;
    }



    @Override
    @Transactional(readOnly = true)
    public List<CarDto> getCars() {
        return carRepository.findAll()
                .stream()
                .map(carEntity -> new CarDto(
                        carEntity.getId(),
                        carEntity.getVin(),
                        carEntity.getRegistrationNumber(),
                        carEntity.getMileageKm(),
                        carEntity.getProductionYear(),
                        carEntity.getModelEntity().getName(),
                        carEntity.getModelEntity().getId())).toList();
    }

    @Override
    public CarDto getCarById(Integer id) {
        var carEntity = carRepository.findById(id).orElseThrow(()->new CarException(CarErrorEnum.CAR_NOT_FOUND));
        return new CarDto(
                carEntity.getId(),
                carEntity.getVin(),
                carEntity.getRegistrationNumber(),
                carEntity.getMileageKm(),
                carEntity.getProductionYear(),
                carEntity.getModelEntity().getName(),
                carEntity.getModelEntity().getId());
    }

    @Override
    @Transactional
    public void addCar(Integer modelId, CarDto carDto) {
        ModelEntity modelEntity = modelRepository.findById(modelId).orElseThrow(() -> new CarException(CarErrorEnum.CAR_NOT_FOUND));
        CarEntity carEntity = new CarEntity();
        carEntity.setVin(carDto.vin());
        carEntity.setRegistrationNumber(carDto.registrationNumber());
        carEntity.setMileageKm(carDto.mileageKm());
        carEntity.setProductionYear(carDto.productionYear());
        carEntity.setModelEntity(modelEntity);
        carRepository.save(carEntity);
    }

    @Override
    public void updateCar(Integer id, CarDto carDto) {
        CarEntity carEntity = carRepository.findById(id).orElseThrow(() -> new CarException(CarErrorEnum.CAR_NOT_FOUND));
        carEntity.setVin(carDto.vin());
        carEntity.setRegistrationNumber(carDto.registrationNumber());
        carEntity.setMileageKm(carDto.mileageKm());
        carEntity.setProductionYear(carDto.productionYear());
    }

    @Override
    public void deleteCarById(Integer id) {
        CarEntity carEntity = carRepository.findById(id).orElseThrow(()-> new CarException(CarErrorEnum.CAR_NOT_FOUND));
        carRepository.delete(carEntity);

    }
}
