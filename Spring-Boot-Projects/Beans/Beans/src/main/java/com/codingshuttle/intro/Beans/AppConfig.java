package com.codingshuttle.intro.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig
{
    @Bean
    @Scope("application") // 🔹 Application Scope (WEB ONLY)
    // One object per ServletContext (entire application)
    // Similar to singleton but tied to web app lifecycle
    public PaymentService paymentService()
    {
        // More logic
        return new PaymentService();
    }


}
