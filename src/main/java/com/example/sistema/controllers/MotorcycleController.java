package com.example.sistema.controllers;

import com.example.sistema.models.vehiclesModels.Motorcycle;
import com.example.sistema.services.vehicleServices.MotorcycleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/motorcycle")
@Validated
public class MotorcycleController {

    @Autowired
    private MotorcycleService motorcycleService;

    @PostMapping
    @Validated(Motorcycle.CreateMotorcycle.class)
    public ResponseEntity<Motorcycle> create(@Valid @RequestBody Motorcycle motorcycleObj) {
        Motorcycle motorcycle = motorcycleService.create(motorcycleObj);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(motorcycle.getId())
                .toUri();
        return ResponseEntity.created(uri).body(motorcycle);
    }

    @GetMapping
    public ResponseEntity<List<Motorcycle>> findAll() {
        List<Motorcycle> motorcycles = motorcycleService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(motorcycles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motorcycle> findById(@PathVariable Long id) {
        Motorcycle motorcycle = motorcycleService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(motorcycle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Motorcycle> update(@Valid @RequestBody Motorcycle motorcycleObj, @PathVariable Long id) {
        motorcycleObj.setId(id);
        Motorcycle motorcycle = motorcycleService.update(motorcycleObj);
        return ResponseEntity.status(HttpStatus.OK).body(motorcycle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        motorcycleService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Moto deletada!");
    }
}
