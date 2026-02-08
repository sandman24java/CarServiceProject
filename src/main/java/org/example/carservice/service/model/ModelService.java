package org.example.carservice.service.model;

import org.example.carservice.dto.cars.dto.ModelDto;

import java.util.List;

public interface ModelService {

    List<ModelDto> getModels();

    ModelDto getModelById(Integer id);

    void addModel(Long BrandId, ModelDto modelDto);

    void updateModel(Integer id, ModelDto modelDto);

    void deleteModelById(Integer id);
}
