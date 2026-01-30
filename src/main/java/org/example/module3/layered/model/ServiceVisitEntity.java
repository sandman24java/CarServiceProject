package org.example.module3.layered.model;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "service_visit",schema="carsdb")
public class ServiceVisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "service_date")
    private LocalDateTime serviceDate;

    @Column(name = "odometer_km")
    private Integer odometerKm;

    @Column(name = "service_type")
    private String serviceType;

    @Column
    private String notes;

    @ManyToOne
    @JoinColumn(name="car_id")
    private CarEntity carEntity;

    @OneToMany(mappedBy = "serviceVisit")
    private List<ServicePartEntity> servicePartEntities;


}
