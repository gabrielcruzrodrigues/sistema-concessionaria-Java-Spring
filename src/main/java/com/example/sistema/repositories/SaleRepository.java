package com.example.sistema.repositories;

import com.example.sistema.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query(value = "SELECT * FROM sale WHERE seller_id = :id", nativeQuery = true)
    List<Sale> findBySellerId(@Param("id") Long id);

}
