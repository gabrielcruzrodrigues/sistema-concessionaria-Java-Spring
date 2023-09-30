package com.example.sistema.services;

import com.example.sistema.models.Sale;
import com.example.sistema.repositories.SaleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired CarService carService;

    @Transactional
    public Sale create(Sale saleObj) {
        saleObj.setId(null);
        saleObj.setCreateAt(LocalDateTime.now());
        Sale saleSave = saleRepository.save(saleObj);

        carService.setNotActive(saleSave.getCarId().getId());

        return saleSave;
    }

    public Sale findById(Long id) {
        Optional<Sale> sale = saleRepository.findById(id);
        return sale.orElseThrow(() -> new RuntimeException("venda não encontrada"));
    }

    @Transactional
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }
}
