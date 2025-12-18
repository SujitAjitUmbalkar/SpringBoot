

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

// @RequestScope: Spring creates a NEW instance for every single HTTP request.
// If 10 users make a request at the same time, there will be 10 different beans.
// Once the request is finished, this bean is destroyed.
@Component
@RequestScope
public class RequestScopeBean {

    public RequestScopeBean() {
        System.out.println("RequestScopeBean Created (New instance for this HTTP Request)");
    }
}