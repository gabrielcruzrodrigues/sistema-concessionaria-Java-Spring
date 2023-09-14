package com.example.sistema.models;

import com.example.sistema.models.personModels.Client;
import com.example.sistema.models.personModels.Seller;
import com.example.sistema.models.vehiclesModels.Bus;
import com.example.sistema.models.vehiclesModels.Car;
import com.example.sistema.models.vehiclesModels.Motorcycle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "TB_SALES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller sellerId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;

    @OneToOne
    @JoinColumn(name = "bus_id")
    private Bus busId;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car carId;

    @OneToOne
    @JoinColumn(name = "motorcycle_id")
    private Motorcycle motorcycleId;

//    private Date createdAt;
}
