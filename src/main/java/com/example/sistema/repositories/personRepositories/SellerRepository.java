package com.example.sistema.repositories.personRepositories;

import com.example.sistema.models.personModels.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
}
