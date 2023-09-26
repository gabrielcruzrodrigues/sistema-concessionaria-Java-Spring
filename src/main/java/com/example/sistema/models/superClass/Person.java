package com.example.sistema.models.superClass;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", length = 60, nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 3, max = 60)
    private String name;

    @Column(name = "dateOfBirth", nullable = false)
    @NotNull
    private Date dateOfBirth;

    @CPF
    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    @NotNull
    @NotBlank
    @Size(min = 14, max = 14)
    private String cpf;

    @Column(name = "address", length = 60, nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 5, max = 60)
    private String address;

    @Column(name = "phoneNumber", length = 11, nullable = false, unique = true)
    @NotNull
    @NotBlank
    @Size(min = 11, max = 11)
    private String phoneNumber;

    @Email
    @Column(name = "email", length = 60, nullable = false, unique = true)
    @NotNull
    @NotBlank
    @Size(min = 11, max = 60)
    private String email;

    @Column(name = "nationality", length = 30, nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 2, max = 2)
    private String nationality;

    @Column(name = "isActive", nullable = false)
    @NotNull
    private Boolean isActive;

//    public Person(Long id, String name, String cpf, String address, String phoneNumber, String email, String nationality, Boolean isActive) {
//
//        this.id = id;
//        this.name = name;
//        this.cpf = cpf;
//        this.address = address;
//        this.phoneNumber = phoneNumber;
//        this.email = email;
//        this.nationality = nationality;
//        this.isActive = isActive;
//    }
}
