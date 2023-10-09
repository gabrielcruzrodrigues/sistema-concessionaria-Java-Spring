package com.example.sistema.controllers;

import com.example.sistema.models.personModels.Seller;
import com.example.sistema.services.personServices.SellerService;
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
@RequestMapping("/seller")
@Validated
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping
    public ResponseEntity<Seller> create(@Valid @RequestBody Seller seller) {
        sellerService.create(seller);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(seller.getId())
                .toUri();

        return ResponseEntity.created(uri).body(seller);
    }

    @GetMapping
    public ResponseEntity<List<Seller>> findAllSellers() {
        List<Seller> sellers = sellerService.findAllSellers();
        return ResponseEntity.status(HttpStatus.OK).body(sellers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> findById(@PathVariable Long id) {
        Seller seller = sellerService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(seller);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@Valid @RequestBody Seller sellerObj, @PathVariable Long id) {
        Seller seller = sellerService.update(sellerObj, id);
        return ResponseEntity.status(HttpStatus.OK).body(seller);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        sellerService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
