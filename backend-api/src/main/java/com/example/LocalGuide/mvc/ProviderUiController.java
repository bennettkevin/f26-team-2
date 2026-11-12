package com.example.LocalGuide.mvc;

import javax.security.auth.login.LoginException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.example.LocalGuide.service.GuideService;
import com.example.LocalGuide.entity.Guide;
import com.example.LocalGuide.service.GuideTourService;

import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.LocalGuide.entity.GuideTour;

@Controller 
@RequestMapping("/provider")
public class ProviderUiController {
    GuideService guideService;
    GuideTourService guideTourService;

    public ProviderUiController(GuideService guideService, GuideTourService guideTourService) {
        this.guideService = guideService;
        this.guideTourService = guideTourService;
    }

    @GetMapping("/login")
    public String login() {
        return "provider/provider-login";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Long userId;
        // Catch the error and give a graceful response to user.
        try {
        userId = UiSession.requireId(session, "provider");
        } catch (LoginException e) {
            model.addAttribute("error", e.getMessage());
            return "provider/provider-login";
        }
        Guide guide = guideService.getGuideById(userId);
        model.addAttribute("guide", guide);
        model.addAttribute("tours", guideTourService.getGuideToursByGuideId(userId));
        return "provider/provider-dashboard";
    }

    @GetMapping("/register")
    public String register() {
        return "provider/provider-registration";
    }

    @GetMapping("/add-tour")
    public String addTour(HttpSession session, Model model) {
        Long userId;
        try {
        userId = UiSession.requireId(session, "provider");
        } catch (LoginException e) {
            model.addAttribute("error", e.getMessage());
            return "provider/provider-login";
        }
        Guide guide = guideService.getGuideById(userId);
        model.addAttribute("guide", guide);
        return "provider/add-tour";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute Guide guide) {
        guideService.createGuide(guide);

        return "redirect:/provider/login";
    }

    @PostMapping("/login")
    public String providerLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Guide guide = guideService.guideLogin(email, password);

        if (guide != null) {
            session.setAttribute("userId", guide.getId());
            session.setAttribute("role", "provider");
            return "redirect:/provider/dashboard";
        } 
        else {
            model.addAttribute("error", "Invalid email or password.");
            return "provider/provider-login";
        }
    }

    @PostMapping("/add-tour")
    // @ModelAttribute can bind form data to a java object. In this case GuideTour.
    public String addTourSubmit(HttpSession session, @ModelAttribute GuideTour guideTour, Model model) {
        Long userId;
        try {
            userId = UiSession.requireId(session, "provider");
        } catch (LoginException e) {
            model.addAttribute("error", e.getMessage());
            return "provider/provider-login";
        }

        guideTour.setGuide(guideService.getGuideById(userId));
        guideTourService.createGuideTour(guideTour);

        return "redirect:/provider/dashboard";
    }

    @GetMapping("/logout")
    public String providerLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/provider/login";
    }
}
