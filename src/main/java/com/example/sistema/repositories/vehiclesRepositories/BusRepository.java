package com.example.sistema.repositories.vehiclesRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sistema.models.vehiclesModels.Bus;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
}
