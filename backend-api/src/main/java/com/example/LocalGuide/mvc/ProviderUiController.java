package com.example.LocalGuide.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/provider")
public class ProviderUiController {
    @GetMapping("/login")
    public String login() {
        return "provider/provider-login";
    }
}
