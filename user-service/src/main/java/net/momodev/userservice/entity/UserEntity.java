package net.momodev.userservice.entity;

import jakarta.persistence.*;
import lombok.*;
import net.momodev.userservice.models.RolesEntity;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    @Transient
    private RolesEntity rolesEntity;
    private Long rolesEntityId;

}
