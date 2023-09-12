package com.example.sistema.models.personModels;

import com.example.sistema.models.superClass.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "TB_CLIENTS")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Client extends Person {

    public interface CreatePerson{}
    public interface UpdatePerson{}

    @Column(name = "isActive", nullable = false)
    @NotNull(groups = CreatePerson.class)
    @NotBlank(groups = CreatePerson.class)
    private Boolean isActive;

    @Column(name = "lastPurchase", nullable = false)
    @NotNull(groups = CreatePerson.class)
    @NotBlank(groups = CreatePerson.class)
    private Date lastPurchase;

    @Column(name = "creditCompany",length = 20, nullable = false)
    @NotNull(groups = CreatePerson.class)
    @NotBlank(groups = CreatePerson.class)
    private Double creditCompany;

    @Column(name = "monthlySalary",length = 20, nullable = false)
    @NotNull(groups = CreatePerson.class)
    @NotBlank(groups = CreatePerson.class)
    private Double monthlySalary;

    @Column(name = "approvedFinancing", nullable = false)
    @NotNull(groups = CreatePerson.class)
    @NotBlank(groups = CreatePerson.class)
    private Boolean approvedFinancing;
}
