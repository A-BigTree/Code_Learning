/**
 * ==================================================
 * Project: springMVC_project
 * Package: seu.springMVC.handler
 * =====================================================
 * Title: HelloWorldHandler.java
 * Created: [2023/4/5 14:43] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/5, created by Shuxin-Wang.
 * 2.
 */

package seu.springMVC.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class HelloWorldHandler {

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/say/hello/to/spring/mvc")
    public String sayHello(){
        log.debug("Hello world to SpringMVC");
        return "target";
    }
}
