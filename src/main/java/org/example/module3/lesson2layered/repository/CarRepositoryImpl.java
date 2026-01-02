package org.example.module3.lesson2layered.repository;

import org.example.module3.lesson2layered.model.CarEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CarRepositoryImpl implements CarRepository {
    List<CarEntity> carEntities = new ArrayList<>();


    @Override
    public List<CarEntity> getCars() {
        return carEntities;
    }

    @Override
    public Optional<CarEntity> getCarById(int id) {
        return carEntities.stream().filter(carEntity->carEntity.getId()==id).findFirst();
    }

    @Override
    public void saveCar(CarEntity carEntity) {
        carEntity.setId(carEntities.size()+1);
        carEntities.add(carEntity);
    }

    @Override
    public void updateCar(int id, CarEntity carEntity) {
        carEntities.stream()
                .filter(entity->entity.getId()==id)
                .findFirst()
                .ifPresent(entity->{
                    entity.setName(carEntity.getName());
                    entity.setColor(carEntity.getColor());
                    entity.setSpeed(carEntity.getSpeed());
                });

    }

    @Override
    public void deleteCarById(int id) {
        carEntities.removeIf(carEntity->carEntity.getId()==id);
    }
}
