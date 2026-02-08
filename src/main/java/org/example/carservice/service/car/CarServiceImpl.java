package org.example.carservice.service.car;

import org.example.carservice.dto.cars.dto.CarDto;
import org.example.carservice.exception.CarErrorEnum;
import org.example.carservice.exception.CarException;
import org.example.carservice.model.CarEntity;
import org.example.carservice.model.ModelEntity;
import org.example.carservice.repository.cars.repository.CarRepository;
import org.example.carservice.repository.cars.repository.ModelRepository;
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
