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
@Table(name = "TB_EMPLOYEES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Employee extends Person {

    public interface CreateEmployee{}
    public interface UpdateEmployee{}

    @Column(name = "hiringDate", nullable = false)
    @NotNull(groups = CreateEmployee.class)
    @NotBlank(groups = CreateEmployee.class)
    private Date hiringDate;

    @Column(name = "sector", length = 20, nullable = false)
    @NotNull(groups = CreateEmployee.class)
    @NotBlank(groups = CreateEmployee.class)
    @Size(groups = CreateEmployee.class, min = 2, max = 20)
    private String sector;

    @Column(name = "Area", length = 30, nullable = false)
    @NotNull(groups = CreateEmployee.class)
    @NotBlank(groups = CreateEmployee.class)
    @Size(groups = CreateEmployee.class, min = 2, max = 30)
    private String Area;

    @Column(name = "workSchedule", length = 14, nullable = false)
    @NotNull(groups = CreateEmployee.class)
    @NotBlank(groups = CreateEmployee.class)
    @Size(groups = CreateEmployee.class, min = 13, max = 14)
    private String workSchedule;

    @Column(name = "salary", length = 10, nullable = false)
    @NotNull(groups = CreateEmployee.class)
    @Size(groups = CreateEmployee.class, min = 2, max = 10)
    private Double salary;

    @Column(name = "pcd", nullable = false)
    @NotNull(groups = CreateEmployee.class)
    private Boolean pcd;

}
