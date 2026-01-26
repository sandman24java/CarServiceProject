package org.example.module3.layered.service;

import org.example.module3.layered.dto.BrandDto;
import org.example.module3.layered.dto.ModelDto;
import org.example.module3.layered.exception.CarErrorEnum;
import org.example.module3.layered.exception.CarException;
import org.example.module3.layered.model.BrandEntity;
import org.example.module3.layered.model.ModelEntity;
import org.example.module3.layered.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    public final BrandRepository brandRepository;

    @Autowired
    public CarServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<BrandDto> getBrands() {
        return brandRepository.findAllOptimised()
                .stream()
                .map(brandEntity -> new BrandDto(
                        brandEntity.getId(),
                        brandEntity.getName(),
                        brandEntity.getCountry(),
                        brandEntity.getFoundedYear(),

                        // Маппим список моделей
                        brandEntity.getModelEntities()
                                .stream()
                                .map(modelEntity -> new ModelDto(
                                        modelEntity.getId(),
                                        modelEntity.getName(),
                                        modelEntity.getCategory(),
                                        modelEntity.getYearFrom(),
                                        modelEntity.getYearTo()
                                )).toList()
                )).toList();
    }


    @Override
    @Transactional(readOnly = true)
    public BrandDto getBrandById(Long id) {
        BrandEntity brand = brandRepository.findById(id).orElseThrow(() -> new CarException(CarErrorEnum.CAR_NOT_FOUND));
        return new BrandDto(brand.getId(),brand.getName(), brand.getCountry(), brand.getFoundedYear(),brand.getModelEntities()
                .stream()
                .map(modelEntity -> new ModelDto(
                        modelEntity.getId(),
                        modelEntity.getName(),
                        modelEntity.getCategory(),
                        modelEntity.getYearFrom(),
                        modelEntity.getYearTo()
                )).toList());
    }

    @Override
    @Transactional
    public void addBrand(BrandDto brandDto) {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName(brandDto.name());
        brandEntity.setFoundedYear(brandDto.foundedYear());
        brandEntity.setCountry(brandDto.country());
        var listOfModelEntities = Optional.ofNullable(brandDto.modelDtoList())
                .orElse(Collections.emptyList())
                .stream()
                .map(modelDto->new ModelEntity(
                        modelDto.id(),
                        modelDto.name(),
                        modelDto.category(),
                        modelDto.yearFrom(),
                        modelDto.yearTo(),
                        brandEntity
                        )).toList();
        brandEntity.setModelEntities(listOfModelEntities);
        brandRepository.save(brandEntity);
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
