package com.example.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sistema.models.Car;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {


}
