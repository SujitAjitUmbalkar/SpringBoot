

import org.springframework.stereotype.Controller;

// @Controller marks this class as a Web Controller.
// It handles incoming HTTP requests and returns views (HTML) or data (JSON).
// Usually used with @RequestMapping to map URLs.
@Controller
public class WebController {

    public void handleRequest() {
        System.out.println("Handling web request inside Controller...");
    }
}
