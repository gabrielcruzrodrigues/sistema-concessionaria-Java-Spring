package com.example.sistema.controllers;

import com.example.sistema.models.personModels.Client;
import com.example.sistema.services.personServices.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/client")
@Validated
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    @Validated(Client.CreatePerson.class)
    public ResponseEntity<Client> create (@Valid @RequestBody Client client) {
        this.clientService.create(client);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(client.getId())
                .toUri();

        return ResponseEntity.created(uri).body(client);
    }

}
