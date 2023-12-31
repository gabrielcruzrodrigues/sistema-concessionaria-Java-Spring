package com.example.sistema.models;

import com.example.sistema.models.superClass.Vehicle;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Slf4j
@Entity
@Table(name = "CAR")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode
public class Car extends Vehicle {


    public interface CreateCar{}
    public interface UpdateCar{}

    @Column(name = "electricWindows", nullable = false)
    @NotNull(groups = CreateCar.class)
    private Boolean electricWindows;

    @Column(name = "automaticTransmission", nullable = false)
    @NotNull(groups = CreateCar.class)
    private Boolean automaticTransmission;

    @Column(name = "traction", nullable = false)
    @NotNull(groups = CreateCar.class)
    private String traction;

    @Column(name = "hydraulicSteering", nullable = false)
    @NotNull(groups = CreateCar.class)
    private Boolean hydraulicSteering;

    @Column(name = "gps", nullable = false)
    @NotNull(groups = CreateCar.class)
    private Boolean gps;

    @Column(name = "sunroof", nullable = false)
    @NotNull(groups = CreateCar.class)
    private Boolean sunroof;

    @Column(name = "sensorsAndCameras", nullable = false)
    @NotNull(groups = CreateCar.class)
    private Boolean sensorsAndCameras;

    @JsonBackReference
    @OneToOne(mappedBy = "carId")
    private Sale sale;

    public Car(String name, String manufactureYear, String plate, String color, String chassi, String model, String stage, Double mileage,
               String weight, String fuelConsumptionPerLiter, String motor, String power, String torque, boolean isActive,
               boolean electricWindows, boolean automaticTransmission, String traction, boolean hydraulicSteering, boolean gps,
               boolean sunroof, boolean sensorsAndCameras) {

        super(name, manufactureYear, plate, color, chassi, model, stage, mileage, weight, fuelConsumptionPerLiter, motor, power, torque, isActive);
        this.electricWindows = electricWindows;
        this.automaticTransmission = automaticTransmission;
        this.traction = traction;
        this.hydraulicSteering = hydraulicSteering;
        this.gps = gps;
        this.sunroof = sunroof;
        this.sensorsAndCameras = sensorsAndCameras;

        log.info("passou construtor");
    }
}
