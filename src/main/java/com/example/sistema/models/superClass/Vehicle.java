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

    public interface CreateVehicle{}
    public interface UpdateVehicle{}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "plate", length = 7, nullable = false)
    @NotNull(groups = CreateVehicle.class)
    @NotBlank(groups = CreateVehicle.class)
    @Size(groups = CreateVehicle.class, min = 7, max = 7)
    private String plate;

    @Column(name = "color", length = 20, nullable = false)
    @NotNull(groups = CreateVehicle.class)
    @NotBlank(groups = CreateVehicle.class)
    @Size(groups = CreateVehicle.class, min = 3, max = 20)
    private String color;

    @Column(name = "manufacturingDate", nullable = false)
    @NotNull(groups = CreateVehicle.class)
    @NotBlank(groups = CreateVehicle.class)
    private Date manufacturingDate;

    @Column(name = "model", length = 30, nullable = false)
    @NotNull(groups = CreateVehicle.class)
    @NotBlank(groups = CreateVehicle.class)
    @Size(groups = CreateVehicle.class, min = 3, max = 30)
    private String model;

    @Column(name = "stage", length = 5, nullable = false)
    @NotNull(groups = CreateVehicle.class)
    @NotBlank(groups = CreateVehicle.class)
    @Size(groups = CreateVehicle.class, min = 4, max = 5)
    private String stage;

    @Column(name = "mileage", nullable = false)
    @NotNull(groups = CreateVehicle.class)
    @NotBlank(groups = CreateVehicle.class)
    private Double mileage;

    @Column(name = "weight", nullable = false)
    @NotNull(groups = CreateVehicle.class)
    @NotBlank(groups = CreateVehicle.class)
    private Double weight;

    @Column(name = "fuelConsumptionPerLiter", nullable = false)
    @NotNull(groups = CreateVehicle.class)
    @NotBlank(groups = CreateVehicle.class)
    private Double fuelConsumptionPerLiter;

    @Column(name = "motor", length = 10, nullable = false)
    @NotNull(groups = CreateVehicle.class)
    @NotBlank(groups = CreateVehicle.class)
    @Size(groups = CreateVehicle.class, min = 5, max = 10)
    private String motor;

    @Column(name = "power", nullable = false)
    @NotNull(groups = CreateVehicle.class)
    @NotBlank(groups = CreateVehicle.class)
    private Double power;

    @Column(name = "torque", nullable = false)
    @NotNull(groups = CreateVehicle.class)
    @NotBlank(groups = CreateVehicle.class)
    private Double torque;
}