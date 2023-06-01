package com.akbank.userservice.entity;

import com.akbank.core.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Size(min = 3, message = "akbank.firstname.size.message")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(min = 3, message = "akbank.lastname.size.message")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "akbank.username.message")
    @Column(name = "username", nullable = false , unique = true)
    private String userName;

    @NotNull(message = "akbank.password.message")
    @Column(name = "password", nullable = false)
    private String password;

}
