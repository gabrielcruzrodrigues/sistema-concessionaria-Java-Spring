package com.example.sistema.models.personModels;

import com.example.sistema.models.superClass.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Employee extends Person {

    public interface CreateEmployee{}
    public interface UpdateEmployee{}

    @Column(name = "sector", length = 60, nullable = false)
    @NotNull(groups = CreateEmployee.class)
    @NotBlank(groups = CreateEmployee.class)
    @Size(groups = CreateEmployee.class, min = 2, max = 60)
    private String sector;

    @Column(name = "Area", length = 30, nullable = false)
    @NotNull(groups = CreateEmployee.class)
    @NotBlank(groups = CreateEmployee.class)
    @Size(groups = CreateEmployee.class, min = 2, max = 30)
    private String area;

    @Column(name = "workSchedule", length = 30, nullable = false)
    @NotNull(groups = CreateEmployee.class)
    @NotBlank(groups = CreateEmployee.class)
    @Size(groups = CreateEmployee.class, min = 13, max = 30)
    private String workSchedule;

    @Column(name = "salary", length = 10, nullable = false)
    @NotNull(groups = CreateEmployee.class)
    @Size(groups = CreateEmployee.class, min = 2, max = 10)
    private Double salary;

    @Column(name = "pcd", nullable = false)
    @NotNull(groups = CreateEmployee.class)
    private Boolean pcd;

    public Employee(Long id, String name, Date dateOfBirth, String cpf, String address, String phoneNumber, String email, String nationality,
                  Boolean isActive, String sector, String area, String workSchedule, Double salary, boolean pcd) {
        super(id, name, dateOfBirth, cpf, address, phoneNumber, email, nationality, isActive);
        this.sector = sector;
        this.area = area;
        this.workSchedule = workSchedule;
        this.salary = salary;
        this.pcd = pcd;
    }

}
