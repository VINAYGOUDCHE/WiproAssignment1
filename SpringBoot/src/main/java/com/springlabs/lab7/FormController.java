package com.springlabs.lab7;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class FormController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());

        model.addAttribute("sections", List.of("Graduate", "Post Graduate", "Research"));
        model.addAttribute("countries", List.of("INDIA", "USA", "CANADA"));
        model.addAttribute("subjects", List.of("Physics", "Chemistry", "Life Science", "Political Science"));

        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute("student") @Valid Student student,
                             BindingResult result, Model model) {

        model.addAttribute("sections", List.of("Graduate", "Post Graduate", "Research"));
        model.addAttribute("countries", List.of("INDIA", "USA", "CANADA"));
        model.addAttribute("subjects", List.of("Physics", "Chemistry", "Life Science", "Political Science"));

        if (result.hasErrors()) {
            return "form";
        }

        return "success";
    }
}

