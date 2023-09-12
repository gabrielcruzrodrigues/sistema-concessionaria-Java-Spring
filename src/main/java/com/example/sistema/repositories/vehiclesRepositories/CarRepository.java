package com.example.sistema.repositories.vehiclesRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sistema.models.vehiclesModels.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
