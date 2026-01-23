package org.example.module3.layered.model;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "model",schema="carsdb")
public class ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String category;

    @Column(name="year_from")
    private Integer yearFrom;

    @Column(name="year_to")
    private Integer yearTo;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private BrandEntity brandEntity;

}
