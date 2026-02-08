package org.example.carservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "feature", schema = "carsdb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id") // Лучше сравнивать только по ID
public class FeatureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "feature_id", unique = true)
    private Integer featureId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @ManyToMany(mappedBy = "featureEntities")
    private List<CarEntity> cars;

}