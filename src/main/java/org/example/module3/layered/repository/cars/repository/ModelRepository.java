package org.example.module3.layered.repository.cars.repository;

import org.example.module3.layered.model.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelRepository extends JpaRepository<ModelEntity,Integer> {

    @Query("SELECT m FROM ModelEntity as m JOIN FETCH m.carEntities")
    public List<ModelEntity> findAllOptimised();

}
