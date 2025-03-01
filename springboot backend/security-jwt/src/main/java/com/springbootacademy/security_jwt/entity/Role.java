package com.springbootacademy.security_jwt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {

    @Id
    @Column(name = "role_name", nullable = false)
    private String roleName;
    private String roleDescription;
}
