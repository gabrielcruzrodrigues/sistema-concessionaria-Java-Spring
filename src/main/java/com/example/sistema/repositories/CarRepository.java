package com.example.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sistema.models.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
