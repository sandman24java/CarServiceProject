package org.example.module3.layered.service.model;

import org.example.module3.layered.dto.cars.dto.ModelDto;

import java.util.List;

public interface ModelService {

    List<ModelDto> getModels();

    ModelDto getModelById(Integer id);

    void addModel(Long BrandId, ModelDto modelDto);

    void updateModel(Integer id, ModelDto modelDto);

    void deleteModelById(Integer id);
}
