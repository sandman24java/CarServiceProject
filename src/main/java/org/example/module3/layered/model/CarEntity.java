package org.example.module3.layered.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "car",schema="carsdb")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String vin;

    @Column(name="registration_number")
    private String registrationNumber;

    @Column(name="mileage_km")
    private Integer mileageKm;

    @Column(name="production_year")
    private Integer productionYear;

    @OneToOne(mappedBy = "carEntity")
    private CarDetailsEntity carDetailsEntity;

    @ManyToMany
    @JoinTable(
            name="car_feature",
            joinColumns = @JoinColumn(name="car_id"),
            inverseJoinColumns = @JoinColumn(name="feature_id") )
    private List<FeatureEntity> featureEntities;

//    1. name = "car_feature"
//    Это имя той самой третьей таблицы, которая лежит в БД и хранит только пары ID.
//
//            2. joinColumns = @JoinColumn(name="car_id")
//    Это «вход» со стороны текущего класса. Так как ты пишешь это в классе машины, ты говоришь: «В таблице-посреднике колонка с моим ID называется car_id».
//
//            3. inverseJoinColumns = @JoinColumn(name="feature_id")
//    Это «выход» к другой таблице. Ты говоришь: «А колонка с ID того, с кем я связываюсь (фичи), называется feature_id».

}
