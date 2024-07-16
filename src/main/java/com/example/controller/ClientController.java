package com.example.controller;

import com.example.models.Client;
import com.example.services.ClientService;
import com.example.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.http.HttpStatus;
import java.util.Optional;
import com.example.services.CartService;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private CartService cartService;

    @GetMapping("/clients/{clientId}")
    public Optional<Client> read(@PathVariable(name = "clientId") int clientId) {
        return clientService.read(clientId);
    }

    @PostMapping("/clients")
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        clientService.createClient(client, (int) cartService.createCart());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
