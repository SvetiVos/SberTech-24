package com.example.services;

import com.example.models.Client;
import com.example.models.Product;
import com.example.models.Cart;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientService {

    private static final Map<Integer, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();

    private static final Integer CLIENT_ID_HOLDER = 0;

    public List<Client> readAll() {
        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
    }

    public void createClient(Client client) {
        final int clientId = CLIENT_ID_HOLDER + 1;
        client.setClientId(clientId);
        CLIENT_REPOSITORY_MAP.put(clientId, client);
    }

    public Client read(int clientId) {
        return CLIENT_REPOSITORY_MAP.get(clientId);
    }

    public boolean deleteClient(int clientId) {
        return CLIENT_REPOSITORY_MAP.remove(clientId) != null;
    }

}
