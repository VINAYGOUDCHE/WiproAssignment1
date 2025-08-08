package com.springlabs.lab6;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CSSJSController {

    @GetMapping("/")
    public String indexPage() {
        return "index";  // Looks for index.html in templates folder
    }
}

