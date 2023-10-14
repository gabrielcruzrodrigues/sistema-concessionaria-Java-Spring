package com.example.sistema.models;

import com.example.sistema.models.enums.PaymentMethods;
import com.example.sistema.models.personModels.Client;
import com.example.sistema.models.personModels.Seller;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
