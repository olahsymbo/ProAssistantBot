package com.proassistant.ProAssistant.controllers;
import com.proassistant.ProAssistant.entities.Users;
import com.proassistant.ProAssistant.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, HttpSession session) {
        Users users = userService.loginUser(username, password);

        if (users != null) {
            session.setAttribute("users", users);
//            localStorage.setItem('user', JSON.stringify(user)); // Store user in local storage
            return "redirect:/dashboard";
        }
        else {
            return "login";
        }
    }


}
