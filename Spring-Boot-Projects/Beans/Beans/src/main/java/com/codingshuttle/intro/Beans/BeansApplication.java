package com.codingshuttle.intro.Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeansApplication implements CommandLineRunner
{
	public static void main(String[] args) {
		SpringApplication.run(BeansApplication.class, args);
	}

    @Autowired
    PaymentService paymentService;

    @Override
    public void run(String... args) throws Exception
    {
        paymentService.pay();
    }

//    Used for triggering initial operations like service calls (paymentService.pay())
//Ensures execution happens only after all beans are created and dependency injection is complete
//Application flow: main() → SpringApplication.run() → Spring Context Initialization → Bean Creation & Autowiring → CommandLineRunner.run() execution
}
