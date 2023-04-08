/**
 * ==================================================
 * Project: springMVC_project
 * Package: ssm.handler
 * =====================================================
 * Title: UserHandler.java
 * Created: [2023/4/8 21:32] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/8, created by Shuxin-Wang.
 * 2.
 */

package ssm.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.entity.User;
import ssm.service.api.UserService;

import java.util.List;

@Controller
public class UserHandler {
    private final UserService userService;

    public UserHandler(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/get/all")
    public String getUserList(Model model){
        List<User> users = userService.getAll();

        model.addAttribute("users", users);

        return "list";
    }
}
