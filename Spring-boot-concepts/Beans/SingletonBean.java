

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Singleton is the DEFAULT scope.
// Spring creates ONLY ONE instance of this bean.
// Every time you ask for this bean, you get the exact same object.
@Component
@Scope("singleton") // This is optional as it is the default
public class SingletonBean {
    public SingletonBean() {
        System.out.println("SingletonBean created (This happens only ONCE).");
    }
}