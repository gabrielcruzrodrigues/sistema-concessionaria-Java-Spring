package com.example.sistema.models.superClass;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Person {

    public interface CreatePerson{}
    public interface UpdatePerson{}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", length = 60, nullable = false)
    @NotNull(groups = CreatePerson.class)
    @NotBlank(groups = CreatePerson.class)
    @Size(groups = CreatePerson.class, min = 3, max = 60)
    private String name;

    @Column(name = "dateOfBirth", nullable = false)
    @NotNull(groups = CreatePerson.class)
    @NotBlank(groups = CreatePerson.class)
    private Date dateOfBirth;

    @Column(name = "cpf", length = 11, nullable = false)
    @NotNull(groups = CreatePerson.class)
    @NotBlank(groups = CreatePerson.class)
    @Size(groups = CreatePerson.class, min = 11, max = 11)
    private  String cpf;

    @Column(name = "address", length = 60, nullable = false)
    @NotNull(groups = CreatePerson.class)
    @NotBlank(groups = CreatePerson.class)
    @Size(groups = CreatePerson.class, min = 5, max = 60)
    private String address;

    @Column(name = "phoneNumber", length = 11, nullable = false)
    @NotNull(groups = CreatePerson.class)
    @NotBlank(groups = CreatePerson.class)
    @Size(groups = CreatePerson.class, min = 11, max = 11)
    private String phoneNumber;

    @Column(name = "email", length = 60, nullable = false)
    @NotNull(groups = CreatePerson.class)
    @NotBlank(groups = CreatePerson.class)
    @Size(groups = CreatePerson.class, min = 11, max = 60)
    private String email;

    @Column(name = "nationality", length = 30, nullable = false)
    @NotNull(groups = CreatePerson.class)
    @NotBlank(groups = CreatePerson.class)
    @Size(groups = CreatePerson.class, min = 2, max = 30)
    private String nationality;

    @Column(name = "isActive", nullable = false)
    @NotNull(groups = CreatePerson.class)
    @NotBlank(groups = CreatePerson.class)
    private Boolean isActive;
}
