package org.example.carservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "part",schema="carsdb")
public class PartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column(name="part_code")
    private String partCode;

    @Column
    private String description;

    @Column(name="unit_price")
    private BigDecimal bigDecimal;

    @Column
    private String brand;

    @OneToMany(mappedBy = "part")
    private List<ServicePartEntity> servicePartEntities;

}

