package org.example.module3.layered.service.model;

import org.example.module3.layered.dto.BrandDto;
import org.example.module3.layered.dto.CarDto;
import org.example.module3.layered.dto.ModelDto;
import org.example.module3.layered.exception.CarErrorEnum;
import org.example.module3.layered.exception.CarException;
import org.example.module3.layered.model.BrandEntity;
import org.example.module3.layered.model.CarEntity;
import org.example.module3.layered.model.ModelEntity;
import org.example.module3.layered.repository.BrandRepository;
import org.example.module3.layered.repository.CarRepository;
import org.example.module3.layered.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService{
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository){
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }



    @Override
    @Transactional(readOnly = true)
    public List<ModelDto> getModels() {
        return modelRepository.findAllOptimised()
                .stream()
                .map(modelEntity -> new ModelDto(
                        modelEntity.getId(),
                        modelEntity.getName(),
                        modelEntity.getCategory(),
                        modelEntity.getYearFrom(),
                        modelEntity.getYearTo(),

                        // Маппим список моделей
                        modelEntity.getCarEntities()
                                .stream()
                                .map(carEntity -> new CarDto(
                                        carEntity.getId(),
                                        carEntity.getVin(),
                                        carEntity.getRegistrationNumber(),
                                        carEntity.getMileageKm(),
                                        carEntity.getProductionYear()
                                )).toList()
                )).toList();
    }

    @Override
    public ModelDto getModelById(Integer id) {
        var modelEntity = modelRepository.findById(id).orElseThrow(()->new CarException(CarErrorEnum.CAR_NOT_FOUND));
        return new ModelDto(
                modelEntity.getId(),
                modelEntity.getName(),
                modelEntity.getCategory(),
                modelEntity.getYearFrom(),
                modelEntity.getYearTo(),
                modelEntity.getCarEntities()
                        .stream()
                        .map(carEntity -> new CarDto(
                                carEntity.getId(),
                                carEntity.getVin(),
                                carEntity.getRegistrationNumber(),
                                carEntity.getMileageKm(),
                                carEntity.getProductionYear()
                        )).toList()
                );
    }

    @Override
   public void addModel(Long BrandId, ModelDto modelDto) {
        var brandEntity = brandRepository.findById(BrandId).orElseThrow(()->new CarException(CarErrorEnum.CAR_NOT_FOUND));
        ModelEntity modelEntity = new ModelEntity();
        modelEntity.setName(modelDto.name());
        modelEntity.setCategory(modelDto.category());
        modelEntity.setYearFrom(modelDto.yearFrom());
        modelEntity.setYearTo(modelDto.yearTo());
        modelEntity.setBrandEntity(brandEntity);
        var listOfCarEntities = Optional.ofNullable(modelDto.carDtoList())
                .orElse(Collections.emptyList())
                .stream()
                .map(carDto->new CarEntity(
                       carDto.vin(),
                        carDto.registrationNumber(),
                        carDto.mileageKm(),
                        carDto.productionYear(),
                        modelEntity
               )).toList();
        modelEntity.setCarEntities(listOfCarEntities);
        modelRepository.save(modelEntity);

    }

    @Override
    public void updateModel(Integer id, ModelDto modelDto) {
        ModelEntity modelEntity = modelRepository.findById(id).orElseThrow(() -> new CarException(CarErrorEnum.CAR_NOT_FOUND));
        modelEntity.setName(modelDto.name());
        modelEntity.setCategory(modelDto.category());
        modelEntity.setYearFrom(modelDto.yearFrom());
        modelEntity.setYearTo(modelDto.yearTo());
    }

    @Override
    public void deleteModelById(Integer id) {
        ModelEntity modelEntity = modelRepository.findById(id).orElseThrow(()-> new CarException(CarErrorEnum.CAR_NOT_FOUND));
        modelRepository.delete(modelEntity);
    }
}
