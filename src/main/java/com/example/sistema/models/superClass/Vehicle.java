package com.example.sistema.models.superClass;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Vehicle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", length = 30, nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 3, max = 30)
    private String name;

    @Column(name = "manufacture_year")
    @NotNull
    private String manufacture_year;

    @Column(name = "plate", length = 7, nullable = false, unique = true)
    @NotNull
    @NotBlank
    @Size(min = 7, max = 7)
    private String plate;

    @Column(name = "color", length = 20, nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String color;

    @Column(name = "chassi", length = 17, nullable = false, unique = true)
    @NotNull
    @NotBlank
    @Size(min = 17, max = 17)
    private String chassi;

    @Column(name = "model", length = 30, nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 3, max = 30)
    private String model;

    @Column(name = "stage", length = 5, nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 4, max = 5)
    private String stage;

    @Column(name = "mileage", nullable = false)
    @NotNull
    private Double mileage;

    @Column(name = "weight", nullable = false)
    @NotNull
    @NotBlank
    private String weight;

    @Column(name = "fuelConsumptionPerLiter", nullable = false)
    @NotNull
    @NotBlank
    private String fuelConsumptionPerLiter;

    @Column(name = "motor", length = 10, nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 5, max = 10)
    private String motor;

    @Column(name = "power", nullable = false)
    @NotNull
    @NotBlank
    private String power;

    @Column(name = "torque", nullable = false)
    @NotNull
    @NotBlank
    private String torque;

    @Column(name = "isAvailable", nullable = false)
    private Boolean isAvailable;

    public Vehicle(String name, String manufacture_year, String plate, String color, String chassi, String model, String stage, Double mileage,
                   String weight, String fuelConsumptionPerLiter, String motor, String power, String torque, boolean isAvailable) {

        this.name = name;
        this.manufacture_year = manufacture_year;
        this.plate = plate;
        this.color = color;
        this.chassi = chassi;
        this.model = model;
        this.stage = stage;
        this.mileage = mileage;
        this.weight = weight;
        this.fuelConsumptionPerLiter = fuelConsumptionPerLiter;
        this.motor = motor;
        this.power = power;
        this.torque = torque;
        this.isAvailable = isAvailable;
    }
}
