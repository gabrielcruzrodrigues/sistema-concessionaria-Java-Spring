package com.example.sistema.models;

import com.example.sistema.models.personModels.Client;
import com.example.sistema.models.personModels.Seller;
import com.example.sistema.models.Car;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

//    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

//    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

//    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car carId;

    @Column(name = "paymentMethod", nullable = false)
    private PaymentMethods paymentMethod;

    @Column(name = "createAt")
    private LocalDateTime createAt;

}
