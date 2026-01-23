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
@Table(name = "cardetails",schema="carsdb")
public class CarDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="engine_number",nullable = false,length = 20)
    private String engineNumber;

    @Column(name="registration_code")
    private String registrationCode;

    @Column(name="fuel_type")
    private String fuelType;

    @Column(name="engine_capacity")
    private String engineCapacity;

    @Column
    private String color;

    @Column(name="insurance_number")
    private String insuranceNumber;

    @OneToOne
    @JoinColumn(name="car_id")
    private CarEntity carEntity;

}
