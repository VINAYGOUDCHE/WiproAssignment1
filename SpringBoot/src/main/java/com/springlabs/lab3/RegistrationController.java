package com.springlabs.lab3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String showForm() {
        return "RegistrationForm";
    }

    @PostMapping("/register")
    public String submitForm(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String birthday,
            @RequestParam String profession,
            Model model) {

        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("email", email);
        model.addAttribute("birthday", birthday);
        model.addAttribute("profession", profession);
        return "RegistrationSuccess";
    }
}

