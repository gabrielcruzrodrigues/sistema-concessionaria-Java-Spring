package com.example.sistema.models.superClass;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
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
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Employee extends Person {

    @Column(name = "sector", length = 60, nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 2, max = 60)
    private String sector;

    @Column(name = "Area", length = 30, nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    private String Area;

    @Column(name = "workSchedule", length = 30, nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 10, max = 30)
    private String workSchedule;

    @Column(name = "salary", length = 10, nullable = false)
    @NotNull
    private Double salary;

    @Column(name = "pcd", nullable = false)
    @NotNull
    private Boolean pcd;

    public Employee(Long id, @NotNull @NotBlank @Size(min = 3, max = 60) String name, @NotNull @NotBlank Date dateOfBirth,
                    @CPF @NotNull @NotBlank @Size(min = 14, max = 14) String cpf, @NotNull @NotBlank @Size(min = 5, max = 60) String address,
                    @NotNull @NotBlank @Size(min = 11, max = 11) String phoneNumber, @Email @NotNull @NotBlank @Size(min = 11, max = 60) String email,
                    @NotNull @NotBlank @Size(min = 2, max = 2) String nationality, @NotNull Boolean isActive, String sector,
                    String area, String workSchedule, Double salary, Boolean pcd) {

        super(id, name, dateOfBirth, cpf, address, phoneNumber, email, nationality, isActive);
        this.sector = sector;
        Area = area;
        this.workSchedule = workSchedule;
        this.salary = salary;
        this.pcd = pcd;
    }
}
