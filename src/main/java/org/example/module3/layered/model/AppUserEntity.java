package org.example.module3.layered.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "app_user",schema="carsdb")
public class AppUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String username;

    @Column(name="full_name")
    private String fullName;

    @Column
    private String email;

    @Column(name="password_hash")
    private String passwordHash;

    @Column(name="is_active")
    private Boolean isActive;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<RoleEntity> roleEntities;


}
