package com.proassistant.ProAssistant.controllers;

import com.proassistant.ProAssistant.entities.Users;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(Model model, HttpSession session) {
        Users users = (Users) session.getAttribute("users");
        model.addAttribute("username", users.getUsername());
        return "dashboard";
    }

}
