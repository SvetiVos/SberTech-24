package com.example.services;

import com.example.models.Client;
import com.example.models.Cart;
import com.example.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public long createClient(Client client, int cartId) {
        Cart cart = new Cart();
        cart.setCartId(cartId);
        client.setCart(cart);
        clientRepository.save(client);
        return client.getClientId();
    }

    public Optional<Client> read(int clientId) {
        return clientRepository.findById(clientId);
    }
}
