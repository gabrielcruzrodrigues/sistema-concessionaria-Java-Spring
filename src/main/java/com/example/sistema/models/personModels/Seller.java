package com.example.sistema.models.personModels;

import com.example.sistema.models.Sale;
import com.example.sistema.models.superClass.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "TB_SELLERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Seller extends Employee {

    @Column(name = "quantitySales", nullable = false)
    @NotNull
    private Integer quantitySales;

    @Column(name = "quantitySalesMonth", nullable = false)
    @NotNull
    private Integer quantitySalesMonth;

    @Column(name = "valueTotalSalesMonth", nullable = false)
    @NotNull
    private Double valueTotalSalesMonth;

    @Column(name = "cityWork", length = 20, nullable = false)
    @NotNull
    @NotBlank
    private String cityWork;

    public Seller(Long id, String name, Date dateOfBirth, String cpf, String address, String phoneNumber, String email, String nationality,
                  Boolean isActive, String sector, String area, String workSchedule, Double salary, Boolean pcd, Integer quantitySales,
                  Integer quantitySalesMonth, Double valueTotalSalesMonth, String cityWork) {

        super(id, name, dateOfBirth, cpf, address, phoneNumber, email, nationality, isActive, sector, area, workSchedule, salary, pcd);
        this.quantitySales = quantitySales;
        this.quantitySalesMonth = quantitySalesMonth;
        this.valueTotalSalesMonth = valueTotalSalesMonth;
        this.cityWork = cityWork;
    }

    //    @OneToOne
//    @JoinColumn(name = "pessoa_id")
//    private Sale sale;
}
