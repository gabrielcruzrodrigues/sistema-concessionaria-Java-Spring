package com.example.sistema.models.personModels;

import com.example.sistema.models.Sale;
import com.example.sistema.models.superClass.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "TB_CLIENT")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
public class Client extends Person {

    public interface CreatePerson{}
    public interface UpdatePerson{}

//    @Column(name = "lastPurchase", nullable = false)
//    @NotNull(groups = CreatePerson.class)
//    @NotBlank(groups = CreatePerson.class)
//    private Date lastPurchase;

    @Column(name = "creditCompany",length = 20, nullable = false)
    @NotNull(groups = CreatePerson.class)
    private Double creditCompany;

    @Column(name = "monthlySalary",length = 20, nullable = false)
    @NotNull(groups = CreatePerson.class)
    private Double monthlySalary;

    @Column(name = "approvedFinancing", nullable = false)
    @NotNull(groups = CreatePerson.class)
    private Boolean approvedFinancing;

    @OneToOne(mappedBy = "client")
    private Sale sale;

    public Client(Long id, String name, Date dateOfBirth, String cpf, String address, String phoneNumber, String email, String nationality,
                  Boolean isActive, Double creditCompany, Double monthlySalary, Boolean approvedFinancing) {
        super(id, name, dateOfBirth, cpf, address, phoneNumber, email, nationality, isActive);
        this.creditCompany = creditCompany;
        this.monthlySalary = monthlySalary;
        this.approvedFinancing = approvedFinancing;
    }
}
