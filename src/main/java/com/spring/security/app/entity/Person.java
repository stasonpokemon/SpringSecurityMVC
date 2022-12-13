package com.spring.security.app.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "people")
@Data
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username must be filled")
    @Size(min = 2, max = 100, message = "Username must be between 2 and 100 characters")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Password must be filled")
    @Size(min = 6, max = 100, message = "Password must be between 6 and 100 characters")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "Date of birthday must be filled")
    @Column(name = "date_of_birthday")
    private String dateOfBirthday;

    @Column(name = "role")
    private String role;
}
