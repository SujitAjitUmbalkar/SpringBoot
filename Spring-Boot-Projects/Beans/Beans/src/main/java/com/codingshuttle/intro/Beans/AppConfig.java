package com.codingshuttle.intro.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
    @Bean
    public PaymentService paymentService()
    {
        // More logic
        return new PaymentService();               // no need to mark targeted class as componant
    }
//    @Configuration class
//        ↓
//    @Bean method called
//        ↓
//    Object created
//        ↓
//    Stored in ApplicationContext
//        ↓
//    @Autowired anywhere
}
