package com.context.application;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationTest {
    @Test
    public void main(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Application app = context.getBean(Application.class);
        app.getBankClientsApp().setBankClients(true);
        app.userVerification();
    }
}