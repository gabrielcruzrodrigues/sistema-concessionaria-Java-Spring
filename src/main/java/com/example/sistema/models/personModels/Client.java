package com.example.sistema.models.personModels;

import com.example.sistema.models.Sale;
import com.example.sistema.models.superClass.Person;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "CLIENT")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
public class Client extends Person {

    public interface CreatePerson{}
    public interface UpdatePerson{}

    @Column(name = "creditCompany",length = 20, nullable = false)
    @NotNull
    private Double creditCompany;

    @Column(name = "monthlySalary",length = 20, nullable = false)
    @NotNull
    private Double monthlySalary;

    @Column(name = "approvedFinancing", nullable = false)
    @NotNull
    private Boolean approvedFinancing;

    @JsonBackReference
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
