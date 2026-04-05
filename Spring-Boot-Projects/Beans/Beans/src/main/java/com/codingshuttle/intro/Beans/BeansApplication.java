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
    PaymentService paymentService1;

    @Autowired
    PaymentService paymentService2;

    @Override
    public void run(String... args) throws Exception
    {
        System.out.println(paymentService1.hashCode()) ;
        System.out.println(paymentService2.hashCode()) ;
        paymentService1.pay();
        paymentService2.pay();
    }

}
