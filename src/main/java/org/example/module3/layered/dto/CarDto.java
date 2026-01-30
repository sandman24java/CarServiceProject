package org.example.module3.layered.dto;

import jakarta.persistence.*;
import org.example.module3.layered.model.CarDetailsEntity;
import org.example.module3.layered.model.FeatureEntity;
import org.example.module3.layered.model.ModelEntity;
import org.example.module3.layered.model.ServiceVisitEntity;

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
