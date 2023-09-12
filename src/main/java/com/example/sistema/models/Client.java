package com.example.sistema.models;

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
@Table(name = "TB_CLIENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Client extends Person{

    @Column(name = "isActive", nullable = false)
    @NotNull
    @NotBlank
    private Boolean isActive;

    @Column(name = "lastPurchase", nullable = false)
    @NotNull
    @NotBlank
    private Date lastPurchase;

    @Column(name = "creditCompany",length = 20, nullable = false)
    @NotNull
    @NotBlank
    private Double creditCompany;

    @Column(name = "monthlySalary",length = 20, nullable = false)
    @NotNull
    @NotBlank
    private Double monthlySalary;

    @Column(name = "approvedFinancing", nullable = false)
    @NotNull
    @NotBlank
    private Boolean approvedFinancing;
}
