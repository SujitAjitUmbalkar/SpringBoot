package com.codingshuttle.intro.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig
{
    @Bean
    @Scope("websocket")   // 🔹 WebSocket Scope
    // One object per WebSocket session
    public PaymentService paymentService()
    {
        // More logic
        return new PaymentService();
    }


}
