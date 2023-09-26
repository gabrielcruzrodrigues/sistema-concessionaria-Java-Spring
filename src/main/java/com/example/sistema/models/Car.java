package com.example.sistema.models;

import com.example.sistema.models.superClass.Vehicle;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Entity
@Table(name = "TB_CARS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Car extends Vehicle {


    public interface CreateCar{}
    public interface UpdateCar{}

    @Column(name = "electricWindows")
    @NotNull(groups = CreateCar.class)
    private Boolean electricWindows;

    @Column(name = "automaticTransmission")
    @NotNull(groups = CreateCar.class)
    private Boolean automaticTransmission;

    @Column(name = "traction")
    @NotNull(groups = CreateCar.class)
    private String traction;

    @Column(name = "hydraulicSteering")
    @NotNull(groups = CreateCar.class)
    private Boolean hydraulicSteering;

    @Column(name = "gps")
    @NotNull(groups = CreateCar.class)
    private Boolean gps;

    @Column(name = "sunroof")
    @NotNull(groups = CreateCar.class)
    private Boolean sunroof;

    @Column(name = "sensorsAndCameras")
    @NotNull(groups = CreateCar.class)
    private Boolean sensorsAndCameras;
    public Car(String name, String plate, String color, String chassi, String model, String stage, Double mileage, String weight, String fuelConsumptionPerLiter, String motor, String power, String torque,
               boolean isAvailable, boolean electricWindows, boolean automaticTransmission, String traction, boolean hydraulicSteering, boolean gps, boolean sunroof, boolean sensorsAndCameras) {

        super(name, plate, color, chassi, model, stage, mileage, weight, fuelConsumptionPerLiter, motor, power, torque, isAvailable);
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
