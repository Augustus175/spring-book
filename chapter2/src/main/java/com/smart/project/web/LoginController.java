package com.smart.project.web;

import com.smart.project.domain.User;
import com.smart.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author zhangzhibo-linux
 * @date 18-7-22 下午5:33
 */
@RestController
public class LoginController {
    private UserService userService;

    @RequestMapping(value = "/index.html")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(),
                loginCommand.getPassword());
        if (!isValidUser) {
            return new ModelAndView("login", "error", "User or Password error !");
        } else {
            User user = userService.findUserByName(loginCommand.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVist(new Date());
            userService.longinSuccess(user);
            request.getSession().setAttribute("user", user);
            return new ModelAndView("main");
        }
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}