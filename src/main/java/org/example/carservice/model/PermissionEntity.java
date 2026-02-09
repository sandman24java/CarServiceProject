package org.example.carservice.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "permission",schema="carsdb")
public class PermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="http_method")
    private String httpMethod;

    @Column(name="path_pattern")
    private String pathPattern;

    @Column(name="permission_code")
    private String permissionCode;

    @ManyToMany
    @JoinTable(name="role_permission",schema = "carsdb",joinColumns = @JoinColumn(name="permission_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<RoleEntity> roleEntities;

}
