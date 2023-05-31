package com.akbank.roleservice.entity;

import com.akbank.core.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class Role {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;
}
