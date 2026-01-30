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
@Table(name = "service_part",schema="carsdb")
public class ServicePartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "part_id")
    private PartEntity part;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceVisitEntity serviceVisit;
}