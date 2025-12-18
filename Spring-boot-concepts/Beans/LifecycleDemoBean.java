

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LifecycleDemoBean {

    public LifecycleDemoBean() {
        System.out.println("1. Constructor Executed: Object Created.");
    }

    // @PostConstruct runs immediately after the constructor and dependency injection.
    // Perfect for initialization logic (e.g., filling caches, opening DB connections).
    @PostConstruct
    public void init() {
        System.out.println("2. @PostConstruct Executed: Bean is fully ready.");
    }

    public void doWork() {
        System.out.println("3. Bean is doing its actual work...");
    }

    // @PreDestroy runs just before the Spring container removes the bean.
    // Used for cleanup (e.g., closing files, stopping timers).
    @PreDestroy
    public void destroy() {
        System.out.println("4. @PreDestroy Executed: Cleanup before destruction.");
    }
}