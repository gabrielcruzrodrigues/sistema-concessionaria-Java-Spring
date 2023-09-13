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
@Table(name = "TB_MOTORCYCLES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Motorcycle extends Vehicle {

    public interface CreateMotorcycle{}
    public interface UpdateMotorcycle{}

    @Column(name = "displacement", nullable = false)
    @NotNull(groups = CreateMotorcycle.class)
    private Double displacement;

    @Column(name = "clutch", nullable = false)
    @NotNull(groups = CreateMotorcycle.class)
    private Boolean clutch;

    @Column(name = "ignitionSystem", nullable = false)
    @NotNull(groups = CreateMotorcycle.class)
    private Boolean ignitionSystem;
}
