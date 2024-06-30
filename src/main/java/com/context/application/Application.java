package com.context.application;

import lombok.Data;

@Data
public class Application {
    private BankClientsApp bankClientsApp;
    private TransferByPhoneApp transferByPhoneApp;
    private Database database;

    public void userVerification(){
        if (bankClientsApp.getBankClients().equals(false)){
            System.out.println("Пользователь не является клиентом банка");
        }
    }
}
