package com.codingshuttle.intro.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig
{
    @Bean
    @Scope("prototype")   // 🔹 Prototype Scope
    // A NEW object is created every time it is requested from container
    // Example: getBean() called 5 times → 5 different objects
    public PaymentService paymentService()
    {
        // More logic
        return new PaymentService();
    }

}
