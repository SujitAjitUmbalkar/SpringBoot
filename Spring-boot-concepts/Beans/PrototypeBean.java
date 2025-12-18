

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

// Prototype scope means Spring creates a NEW instance every time this bean is requested.
// Useful for stateful beans (beans that hold unique data for a specific task).
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // Equivalent to "prototype"
public class PrototypeBean {
    public PrototypeBean() {
        System.out.println("PrototypeBean created (This happens EVERY TIME it is requested).");
    }
}