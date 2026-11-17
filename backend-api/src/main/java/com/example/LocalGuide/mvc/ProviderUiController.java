package com.example.LocalGuide.mvc;

import javax.security.auth.login.LoginException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

import com.example.LocalGuide.service.GuideService;
import com.example.LocalGuide.entity.Guide;
import com.example.LocalGuide.service.GuideTourService;
import com.example.LocalGuide.entity.Timeslot;
import com.example.LocalGuide.service.TimeslotService;

import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.LocalGuide.entity.GuideTour;

@Controller 
@RequestMapping("/provider")
public class ProviderUiController {
    GuideService guideService;
    GuideTourService guideTourService;
    TimeslotService timeSlotService;

    public ProviderUiController(GuideService guideService, GuideTourService guideTourService, TimeslotService timeSlotService) {
        this.guideService = guideService;
        this.guideTourService = guideTourService;
        this.timeSlotService = timeSlotService;
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
        } 
        catch (LoginException e) {
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
        } 
        catch (LoginException e) {
            model.addAttribute("error", e.getMessage());
            return "provider/provider-login";
        }
        model.addAttribute("guide", guideService.getGuideById(userId));
        return "provider/add-tour";
    }

    @GetMapping("/tour/{tourId}")
    public String viewTour(@PathVariable Long tourId, HttpSession session, Model model) {
        // Used for validation.
        Long userId;
        try {
            userId = UiSession.requireId(session, "provider");
        } 
        catch (LoginException e) {
            model.addAttribute("error", e.getMessage());
            return "provider/provider-login";
        }

        model.addAttribute("guideTour", guideTourService.getGuideTourById(tourId));
        model.addAttribute("guide", guideService.getGuideById(userId));
        return "provider/view-tour";
    }

    @GetMapping("/tour/{tourId}/edit")
    public String editTour(@PathVariable Long tourId, HttpSession session, Model model) {
        Long userId;
        try {
            userId = UiSession.requireId(session, "provider");
        } 
        catch (LoginException e) {
            model.addAttribute("error", e.getMessage());
            return "provider/provider-login";
        }

        GuideTour guideTour = guideTourService.getGuideTourById(tourId);
        if (guideTour == null || !guideTour.getGuide().getId().equals(userId)) {
            model.addAttribute("error", "You do not have permission to edit this tour.");
            return "provider/provider-login";
        }

        model.addAttribute("guideTour", guideTour);
        model.addAttribute("guide", guideService.getGuideById(userId));
        return "provider/edit-tour";
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

    @PostMapping("/delete-account")
    public String deleteAccount(HttpSession session, Model model) {
        // Verify user
        Long userId;
        try {
            userId = UiSession.requireId(session, "provider");
        } catch (LoginException e) {
            model.addAttribute("error", e.getMessage());
            return "provider/provider-login";
        }

        guideService.deleteGuide(userId);
        session.invalidate();
        return "redirect:/provider/login";
    }


    @PostMapping("/add-tour")
    // @ModelAttribute can bind form data to a java object. In this case GuideTour.
    public String addTourSubmit(HttpSession session, @ModelAttribute GuideTour guideTour, Model model) {
        Long userId;
        try {
            userId = UiSession.requireId(session, "provider");
        } 
        catch (LoginException e) {
            model.addAttribute("error", e.getMessage());
            return "provider/provider-login";
        }

        guideTour.setGuide(guideService.getGuideById(userId));
        guideTourService.createGuideTour(guideTour);

        return "redirect:/provider/dashboard";
    }

    @PostMapping("/tour/{tourId}/delete")
    public String deleteTour(@PathVariable Long tourId, HttpSession session, Model model) {
        // Verify the user.
        Long userId;
        try {
            userId = UiSession.requireId(session, "provider");
        } catch (LoginException e) {
            model.addAttribute("error", e.getMessage());
            return "provider/provider-login";
        }

        // Verify tour belongs to user
        GuideTour guideTour = guideTourService.getGuideTourById(tourId);
        if (guideTour == null || !guideTour.getGuide().getId().equals(userId)) {
            // Need to add error message.
            return "redirect:/provider/dashboard";
        }

        guideTourService.deleteGuideTour(tourId);
        return "redirect:/provider/dashboard";
    }


    @PostMapping("/tour/{tourId}/edit")
    public String submitTourChanges(@PathVariable Long tourId, @ModelAttribute GuideTour guideTour, HttpSession session, Model model) {
        Long userId;
        try {
            userId = UiSession.requireId(session, "provider");
        } catch (LoginException e) {
            model.addAttribute("error", e.getMessage());
            return "provider/provider-login";
        }
        
        GuideTour existing = guideTourService.getGuideTourById(tourId);
        if (existing == null || !existing.getGuide().getId().equals(userId)) {
            model.addAttribute("error", "You do not have permission to edit this tour.");
            return "provider/provider-login";
        }

        guideTour.setGuide(guideService.getGuideById(userId));
        guideTourService.updateGuideTour(tourId, guideTour);

        return "redirect:/provider/tour/" + tourId;
    }

    @PostMapping("/tour/{tourId}/timeslots")
    public String addTimeslots(@PathVariable Long tourId,@ModelAttribute Timeslot timeslot, HttpSession session, Model model) {
        // Verify the user
        Long userId;
        try {
            userId = UiSession.requireId(session, "provider");
        } 
        catch (LoginException e) {
            model.addAttribute("error", e.getMessage());
            return "provider/provider-login";
        }

        // Verify the tour and that its from the valid user. 
        GuideTour guideTour = guideTourService.getGuideTourById(tourId);
        if (guideTour == null || !guideTour.getGuide().getId().equals(userId)) {
            model.addAttribute("error", "You do not have permission to add timeslots to this tour.");
            return "provider/provider-dashboard";
        }

        timeslot.setGuideTour(guideTour);
        timeslot.setIsAvailable(true);
        timeSlotService.createTimeslot(timeslot);

        return "redirect:/provider/tour/" + tourId + "/edit";
    }

    @PostMapping("/tour/{tourId}/timeslots/{slotId}/delete")
    public String deleteTimeslot(@PathVariable Long tourId, @PathVariable Long slotId, HttpSession session, Model model) {
        // Verify the user.
        Long userId;
        try {
            userId = UiSession.requireId(session, "provider");
        } catch (LoginException e) {
            model.addAttribute("error", e.getMessage());
            return "provider/provider-login";
        }

        // Verify tour belongs to user
        GuideTour guideTour = guideTourService.getGuideTourById(tourId);
        if (guideTour == null || !guideTour.getGuide().getId().equals(userId)) {
            return "redirect:/provider/dashboard";
        }

        // Verify the timeslot belongs to the tour 
        Timeslot slot = timeSlotService.getTimeslotById(slotId);
        if (slot != null && slot.getGuideTour().getId().equals(tourId)) {
            timeSlotService.deleteTimeslot(slotId);
        }
        return "redirect:/provider/tour/" + tourId + "/edit";
    }


    @GetMapping("/logout")
    public String providerLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/provider/login";
    }
}
