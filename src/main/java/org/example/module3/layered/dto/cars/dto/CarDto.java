package org.example.module3.layered.dto.cars.dto;

import org.example.module3.layered.model.ModelEntity;

public record CarDto(Integer id, String vin, String registrationNumber, Integer mileageKm, Integer productionYear, ModelEntity modelEntity, String modelName, Integer modelId)
{
    public CarDto(String vin, String registrationNumber, Integer mileageKm, Integer productionYear, ModelEntity modelEntity){
        this(null, vin, registrationNumber, mileageKm,productionYear,modelEntity,null,null);
    }
    public CarDto(Integer id, String vin, String registrationNumber, Integer mileageKm, Integer productionYear) {
        this(id, vin, registrationNumber, mileageKm, productionYear,null,null,null);
    }
    public CarDto(Integer id, String vin, String registrationNumber, Integer mileageKm, Integer productionYear, String modelName, Integer modelId) {
        this(id, vin, registrationNumber, mileageKm, productionYear,null,modelName,modelId);
    }
}
