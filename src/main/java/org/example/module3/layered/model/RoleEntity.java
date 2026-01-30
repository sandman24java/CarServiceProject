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
@Table(name = "role",schema="carsdb")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "roleEntities")
    private List<PermissionEntity> permissionEntities;

    @ManyToMany(mappedBy = "roleEntities")
    private List<AppUserEntity> appUserEntities;

}
