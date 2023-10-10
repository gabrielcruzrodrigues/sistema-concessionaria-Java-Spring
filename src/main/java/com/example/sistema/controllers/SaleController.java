package com.example.sistema.controllers;

import com.example.sistema.models.Sale;
import com.example.sistema.services.SaleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("sale")
@Validated
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Sale sale) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saleService.create(sale).getId())
                .toUri();

        return ResponseEntity.created(uri).body("A venda foi cadastrada");
    }

    @GetMapping
    public ResponseEntity<List<Sale>> findAll() {
        return ResponseEntity.ok().body(saleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(saleService.findById(id));
    }

    @GetMapping("/seller/{id}")
    public ResponseEntity<List<Sale>> findBySellerId(@PathVariable Long id) {
        return ResponseEntity.ok().body(saleService.findBySellerId(id));
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<Sale>> findByClientId(@PathVariable Long id) {
        return ResponseEntity.ok().body(saleService.findByClientId(id));
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<List<Sale>> findByCarId(@PathVariable Long id) {
        return ResponseEntity.ok().body(saleService.findByCarId(id));
    }
}
