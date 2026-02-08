package org.example.carservice.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@Setter
@Getter
@Entity
@SQLDelete(sql="UPDATE carsdb.brand SET deleted = true WHERE id=?")
@SQLRestriction("deleted = false")
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

    @Column
    private boolean deleted = false;


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
