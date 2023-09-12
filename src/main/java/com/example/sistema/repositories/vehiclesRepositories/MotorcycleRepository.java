package com.example.sistema.repositories.vehiclesRepositories;

import com.example.sistema.models.vehiclesModels.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {
}
