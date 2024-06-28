package com.Context.Application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    Application app() {
        return null;
    }

    @Bean
    BankClientsApp bankClientsApp() {
        BankClientsApp bankClientsApp = new BankClientsApp();
        bankClientsApp.setBankClients(false);
        return bankClientsApp();
    }

    @Bean
    TransferByPhoneApp transferByPhoneApp() {
        TransferByPhoneApp transferByPhoneApp = new TransferByPhoneApp();
        transferByPhoneApp.setPhoneNumber(895350662);
        transferByPhoneApp.setTransferAmount(600);
        return transferByPhoneApp();
    }
    
    @Bean
    Database database() {
        Database dataBase = new Database();
        dataBase.setClientRecord("Клиент перевел сумму в размере 600 рублей по номеру 895350662");
        return database();
    }
    
}
