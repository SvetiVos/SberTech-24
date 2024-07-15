package com.example.services;

import com.example.models.Client;
import com.example.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public long createClient(Client client, int cartId) {
        clientRepository.createClient(client, cartId);
    }

    public Optional<Client> read(int clientId) {
        return this.clientRepository.read(clientId);
    }
}
