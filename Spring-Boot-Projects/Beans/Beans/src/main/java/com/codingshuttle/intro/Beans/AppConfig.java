package com.codingshuttle.intro.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig
{
    @Bean
    @Scope("session")     // 🔹 Session Scope (WEB ONLY)
    // One object per HTTP session
    // Same bean used across multiple requests in same session
    public PaymentService paymentService()
    {
        // More logic
        return new PaymentService();
    }


}
