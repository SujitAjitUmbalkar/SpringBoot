

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

// @ApplicationScope: Spring creates ONE instance for the entire Servlet Context (Web App).
// It is very similar to Singleton, but specifically for web-aware environments.
// The bean lives as long as the Web Application is running.
@Component
@ApplicationScope
public class ApplicationScopeBean {

    public ApplicationScopeBean() {
        System.out.println("ApplicationScopeBean Created (One instance for the whole Web App)");
    }
}