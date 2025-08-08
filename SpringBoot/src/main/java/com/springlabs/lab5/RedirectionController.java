package com.springlabs.lab5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectionController {

    @GetMapping("/example/test")
    public String redirectToTest2() {
        return "redirect:/example/test2";
    }

    @GetMapping("/example/test2")
    public String handleTest2() {
        return "test2"; // will look for test2.html in templates
    }
}
