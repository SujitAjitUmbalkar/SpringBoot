

import com.codingshuttle.anuj.module1Introduction.PaymentService; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration tells Spring that this class contains bean definitions.
// It acts as a factory for creating beans.
@Configuration
public class AppConfig {

    // @Bean tells Spring: "Execute this method and manage the returned object as a Bean."
    // The ID of the bean will be the method name ('myCustomPaymentService').
    // This is useful for configuring classes you didn't write (external libraries).
    @Bean
    public PaymentService myCustomPaymentService() {
        System.out.println("Creating PaymentService bean manually via @Bean...");
        return new PaymentService();
    }
}

