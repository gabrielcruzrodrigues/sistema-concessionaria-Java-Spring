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
@Table(name = "TB_BUSES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Bus extends Vehicle {

    public interface CreateBus{}
    public interface updateBus{}

    @Column(name = "electricWindows", nullable = false)
    @NotNull(groups = CreateBus.class)
    @NotBlank(groups = CreateBus.class)
    private Boolean electricWindows;

    @Column(name = "automaticTransmission", nullable = false)
    @NotNull(groups = CreateBus.class)
    @NotBlank(groups = CreateBus.class)
    private Boolean automaticTransmission;

    @Column(name = "traction", nullable = false)
    @NotNull(groups = CreateBus.class)
    @NotBlank(groups = CreateBus.class)
    private Boolean traction;

    @Column(name = "hydraulicSteering", nullable = false)
    @NotNull(groups = CreateBus.class)
    @NotBlank(groups = CreateBus.class)
    private Boolean hydraulicSteering;

    @Column(name = "gps", nullable = false)
    @NotNull(groups = CreateBus.class)
    @NotBlank(groups = CreateBus.class)
    private Boolean gps;

    @Column(name = "sunroof", nullable = false)
    @NotNull(groups = CreateBus.class)
    @NotBlank(groups = CreateBus.class)
    private Boolean sunroof;

    @Column(name = "sensorsAndCameras", nullable = false)
    @NotNull(groups = CreateBus.class)
    @NotBlank(groups = CreateBus.class)
    private Boolean sensorsAndCameras;

    @Column(name = "airConditioning", nullable = false)
    @NotNull(groups = CreateBus.class)
    @NotBlank(groups = CreateBus.class)
    private Boolean airConditioning;

    @Column(name = "cameraMonitoring", nullable = false)
    @NotNull(groups = CreateBus.class)
    @NotBlank(groups = CreateBus.class)
    private Boolean cameraMonitoring;

    @Column(name = "Lighting", nullable = false)
    @NotNull(groups = CreateBus.class)
    @NotBlank(groups = CreateBus.class)
    private Boolean Lighting;
}