package com.example.sistema.models.vehiclesModels;

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

@Entity
@Table(name = "TB_CARS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Car extends Vehicle {

    public interface CreateCar{}
    public interface UpdateCar{}

    @Column(name = "electricWindows", nullable = false)
    @NotNull(groups = CreateCar.class)
    @NotBlank(groups = CreateCar.class)
    private Boolean electricWindows;

    @Column(name = "automaticTransmission", nullable = false)
    @NotNull(groups = CreateCar.class)
    @NotBlank(groups = CreateCar.class)
    private Boolean automaticTransmission;

    @Column(name = "traction", nullable = false)
    @NotNull(groups = CreateCar.class)
    @NotBlank(groups = CreateCar.class)
    private Boolean traction;

    @Column(name = "hydraulicSteering", nullable = false)
    @NotNull(groups = CreateCar.class)
    @NotBlank(groups = CreateCar.class)
    private Boolean hydraulicSteering;

    @Column(name = "gps", nullable = false)
    @NotNull(groups = CreateCar.class)
    @NotBlank(groups = CreateCar.class)
    private Boolean gps;

    @Column(name = "sunroof", nullable = false)
    @NotNull(groups = CreateCar.class)
    @NotBlank(groups = CreateCar.class)
    private Boolean sunroof;

    @Column(name = "sensorsAndCameras", nullable = false)
    @NotNull(groups = CreateCar.class)
    @NotBlank(groups = CreateCar.class)
    private Boolean sensorsAndCameras;
}
