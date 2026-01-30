package org.example.module3.layered.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@SQLDelete(sql="UPDATE carsdb.model SET deleted = true WHERE id=?")
@SQLRestriction("deleted = false")
@Table(name = "model",schema="carsdb")
public class ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String category;

    @Column(name="year_from")
    private Integer yearFrom;

    @Column(name="year_to")
    private Integer yearTo;

    @Column
    private boolean deleted = false;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private BrandEntity brandEntity;

    @OneToMany(mappedBy = "modelEntity")
    private List<CarEntity> carEntities;


    public ModelEntity(Integer id, String name, String category, Integer yearFrom, Integer yearTo, BrandEntity brandEntity, List<CarEntity> carEntities) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
        this.brandEntity = brandEntity;
        this.carEntities = carEntities;
    }


    public ModelEntity(Integer id, String name, String category, Integer yearFrom, Integer yearTo, BrandEntity brandEntity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
        this.brandEntity = brandEntity;
    }
}
