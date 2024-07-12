package com.example.models;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Client {
    private int clientId;
    private String nameClient;
    private String login;
    private String password;
    private String email;
    private int cart;
}
