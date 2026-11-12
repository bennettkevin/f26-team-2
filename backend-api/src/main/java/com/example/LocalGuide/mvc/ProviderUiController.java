package com.example.LocalGuide.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.LocalGuide.service.GuideService;
import com.example.LocalGuide.entity.Guide;

@Controller 
@RequestMapping("/provider")
public class ProviderUiController {
    GuideService guideService;

    public ProviderUiController(GuideService guideService) {
        this.guideService = guideService;
    }

    @GetMapping("/login")
    public String login() {
        return "provider/provider-login";
    }

    @GetMapping("/register")
    public String register() {
        return "provider/provider-registration";
    }

    @PostMapping("/register")
    public String registerSubmit(Guide guide) {
        guideService.createGuide(guide);

        return "redirect:/provider/login";
    }

}
