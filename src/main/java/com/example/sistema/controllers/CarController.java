package com.example.sistema.controllers;

import com.example.sistema.models.Car;
import com.example.sistema.services.CarService;
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
@RequestMapping("cars")
@Validated
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    @Validated(Car.CreateCar.class)
    public ResponseEntity<Car> create(@Valid @RequestBody Car carObj)  {
        Car car = carService.create(carObj);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carObj.getId())
                .toUri();

        return ResponseEntity.created(uri).body(car);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        List<Car> cars = carService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id) {
        Car car = carService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(car);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@Valid @RequestBody Car carObj, @PathVariable Long id) {
        Car car = carService.update(carObj, id);
        return ResponseEntity.status(HttpStatus.OK).body(car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
