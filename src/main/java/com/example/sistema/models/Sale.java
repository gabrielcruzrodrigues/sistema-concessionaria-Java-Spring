package com.example.sistema.models;

import com.example.sistema.models.personModels.Client;
import com.example.sistema.models.personModels.Seller;
import com.example.sistema.models.Car;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "SALE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car carId;

    @Column(name = "createAt")
    private LocalDateTime createAt;

}
