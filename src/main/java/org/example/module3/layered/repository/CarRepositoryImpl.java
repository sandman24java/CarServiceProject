package org.example.module3.layered.repository;

import lombok.RequiredArgsConstructor;
import org.example.module3.layered.exception.CarErrorEnum;
import org.example.module3.layered.exception.CarException;
import org.example.module3.layered.model.BrandEntity;
import org.example.module3.layered.model.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CarRepositoryImpl implements CarRepository {

    private final JdbcTemplate jdbcTemplate;

    List<CarEntity> carEntities = new ArrayList<>();


    RowMapper<CarEntity> carRowMapper = (resultSet, row) -> {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String country = resultSet.getString("country");
        Integer foundedYear = resultSet.getInt("founded_year");
        return new CarEntity(id, name, country, foundedYear);
    };


    @Override
    public List<CarEntity> getBrands() {
        String query = """
                SELECT * FROM carsdb.brand
                """;

        return jdbcTemplate.query(query, carRowMapper);
    }


    //    @Override
//    public Optional<CarEntity> getCarById(int id) {
//        return carEntities.stream().filter(carEntity->carEntity.getId()==id).findFirst();
//    }
//
    @Override
    public void addBrand(BrandEntity brandEntity) {
        String query = """
                INSERT INTO carsdb.brand (name,country,founded_year)
                VALUES (?,?,?)
                """;
        jdbcTemplate.update(query,brandEntity.getName(),brandEntity.getCountry(),brandEntity.getFoundedYear());
    }
}
//
//    @Override
//    public void updateCar(int id, CarEntity carEntity) {
//        carEntities.stream()
//                .filter(entity->entity.getId()==id)
//                .findFirst()
//                .ifPresent(entity->{
//                    entity.setName(carEntity.getName());
//                    entity.setColor(carEntity.getColor());
//                    entity.setSpeed(carEntity.getSpeed());
//                });
//
//    }
//
//    @Override
//    public void deleteCarById(int id) {
//        CarEntity carToDelete = carEntities.stream()
//                .filter(car -> car.getId() == id)
//                .findFirst()
//                .orElseThrow(() -> new CarException(CarErrorEnum.CAR_NOT_FOUND, id));
//
//        carEntities.remove(carToDelete);
//    }
//}
//// carEntity->carEntity.getId()==id