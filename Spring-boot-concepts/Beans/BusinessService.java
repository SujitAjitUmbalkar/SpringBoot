
import org.springframework.stereotype.Service;

// @Service marks this class as a Service Layer component.
// It is used to hold business logic, calculations, and rules.
// Functionally identical to @Component, but helps developers understand the architecture.
@Service
public class BusinessService {

    public void logic() {
        System.out.println("Executing business logic inside Service...");
    }
}