package org.example.module3.layered.repository.cars.repository;

import org.example.module3.layered.model.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<BrandEntity,Long> {

    @Query("SELECT b FROM BrandEntity as b JOIN FETCH b.modelEntities")
    public List<BrandEntity> findAllOptimised();


    /**
     * SELECT b: Ты выбираешь весь объект (сущность).
     * JOIN FETCH: Ты приказываешь Hibernate: «Сделай SQL JOIN и сразу заполни коллекцию modelEntities данными из этой же выборки»
     * Результат: Все бренды будут загружены одним SQL-запросом, и у каждого бренда поле со списком моделей уже будет заполнено. Никаких LazyInitializationException и никакого N+1.
     */
}

