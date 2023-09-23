package com.example.sistema.models;

import com.example.sistema.models.personModels.Client;
import com.example.sistema.models.personModels.Seller;
import com.example.sistema.models.Car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_SALES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "sale", cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    private Seller sellerId;

    @OneToOne(mappedBy = "sale", cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client clientId;

//    @OneToOne
//    @JoinColumn(name = "car_id")
//    private Car carId;

//    private Date createdAt;
}
