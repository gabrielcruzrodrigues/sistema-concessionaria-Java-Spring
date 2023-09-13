package com.example.sistema.models.personModels;

import com.example.sistema.models.superClass.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_SELLERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Seller extends Employee {

    public interface CreateSeller{}
    public interface updateSeller{}

    @Column(name = "quantitySales", nullable = false)
    @NotNull(groups = CreateSeller.class)
    @NotBlank(groups = CreateSeller.class)
    private Integer quantitySales;

    @Column(name = "quantitySalesMonth", nullable = false)
    @NotNull(groups = CreateSeller.class)
    @NotBlank(groups = CreateSeller.class)
    private Integer quantitySalesMonth;

    @Column(name = "valueTotalSalesMonth", nullable = false)
    @NotNull(groups = CreateSeller.class)
    @NotBlank(groups = CreateSeller.class)
    private Double valueTotalSalesMonth;

    @Column(name = "cityWork", length = 20, nullable = false)
    @NotNull(groups = CreateSeller.class)
    @NotBlank(groups = CreateSeller.class)
    private String cityWork;
}
