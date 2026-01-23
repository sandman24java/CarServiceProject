package org.example.module3.layered.service;

import org.example.module3.layered.dto.BrandDto;
import org.example.module3.layered.dto.ModelDto;
import org.example.module3.layered.exception.CarErrorEnum;
import org.example.module3.layered.exception.CarException;
import org.example.module3.layered.model.BrandEntity;
import org.example.module3.layered.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return brandRepository.findAll()
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
        return new BrandDto(brand.getName(), brand.getCountry(), brand.getFoundedYear());
    }
}
//
//    @Override
//    @Transactional(readOnly = true)
//    public void addBrand(BrandDto brandDto) {
//        carRepository.addBrand(new BrandEntity(brandDto.name(), brandDto.country(), brandDto.foundedYear()));
//    }
//}
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
