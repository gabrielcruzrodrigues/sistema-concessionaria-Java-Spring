package com.example.sistema.controllers;

import com.example.sistema.models.vehiclesModels.Bus;
import com.example.sistema.services.vehicleServices.BusService;
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
@RequestMapping("/bus")
@Validated
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping
    @Validated(Bus.CreateBus.class)
    public ResponseEntity<Bus> create(@Valid @RequestBody Bus busObj) {
        Bus bus = busService.create(busObj);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(busObj.getId())
                .toUri();

        return ResponseEntity.created(uri).body(bus);
    }

    @GetMapping
    public ResponseEntity<List<Bus>> findAll() {
        List<Bus> buses = busService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(buses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> findById(@PathVariable Long id) {
        Bus bus = busService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(bus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bus> update(@Valid @RequestBody Bus busObj, @PathVariable Long id) {
        busObj.setId(id);
        Bus bus = busService.update(busObj);
        return ResponseEntity.status(HttpStatus.OK).body(bus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        busService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Ônibus deletado!");
    }
}