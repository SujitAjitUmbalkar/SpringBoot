

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

// @SessionScope: Spring creates ONE instance per User Session.
// It remains alive as long as the user is "logged in" or the session is active.
// Different users will have different instances, but the same user gets the same bean across multiple requests.
@Component
@SessionScope
public class SessionScopeBean {

    public SessionScopeBean() {
        System.out.println("SessionScopeBean Created (New instance for this User Session)");
    }
}