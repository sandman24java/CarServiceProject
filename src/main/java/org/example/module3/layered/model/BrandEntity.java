package org.example.module3.layered.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "brand",schema="carsdb")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String country;

    @Column(name="founded_year")
    private Integer foundedYear;


    public BrandEntity(Long id, String name, String country, Integer foundedYear) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.foundedYear = foundedYear;
    }

    public BrandEntity(String name, String country, Integer foundedYear) {
        this.name = name;
        this.country = country;
        this.foundedYear = foundedYear;
    }

    @OneToMany(mappedBy="brandEntity",fetch=FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ModelEntity> modelEntities;

}
