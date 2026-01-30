package org.example.module3.layered.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@SQLDelete(sql="UPDATE carsdb.car SET deleted = true WHERE id=?")
@SQLRestriction("deleted = false")
@Table(name = "car",schema="carsdb")
public class CarEntity {


    public CarEntity(String vin, String registrationNumber, Integer mileageKm, Integer productionYear, ModelEntity modelEntity) {
        this.vin = vin;
        this.registrationNumber = registrationNumber;
        this.mileageKm = mileageKm;
        this.productionYear = productionYear;
        this.modelEntity = modelEntity;
    }
    public CarEntity(Integer id, String vin, String registrationNumber, Integer mileageKm, Integer productionYear) {
        this.id = id;
        this.vin = vin;
        this.registrationNumber = registrationNumber;
        this.mileageKm = mileageKm;
        this.productionYear = productionYear;
    }

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

    @Column
    private boolean deleted = false;

    @OneToOne(mappedBy = "carEntity",fetch = FetchType.EAGER)
    private CarDetailsEntity carDetailsEntity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="car_feature",
            joinColumns = @JoinColumn(name="car_id"),
            inverseJoinColumns = @JoinColumn(name="feature_id") )
    private List<FeatureEntity> featureEntities;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="model_id")
    private ModelEntity modelEntity;

    @OneToMany(mappedBy = "carEntity",fetch = FetchType.LAZY)
    private List<ServiceVisitEntity> serviceVisitEntities;



//    1. name = "car_feature"
//    Это имя той самой третьей таблицы, которая лежит в БД и хранит только пары ID.
//
//            2. joinColumns = @JoinColumn(name="car_id")
//    Это «вход» со стороны текущего класса. Так как ты пишешь это в классе машины, ты говоришь: «В таблице-посреднике колонка с моим ID называется car_id».
//
//            3. inverseJoinColumns = @JoinColumn(name="feature_id")
//    Это «выход» к другой таблице. Ты говоришь: «А колонка с ID того, с кем я связываюсь (фичи), называется feature_id».

}
