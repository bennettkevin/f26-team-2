package com.example.LocalGuide.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.LocalGuide.service.CustomerService;
import com.example.LocalGuide.service.GuideTourService;
import com.example.LocalGuide.service.NotFoundException;
import com.example.LocalGuide.service.GuideService;
import com.example.LocalGuide.entity.Customer;
import com.example.LocalGuide.entity.GuideTour;
import com.example.LocalGuide.entity.Guide;

@Controller
//@RequestMapping("/customer")
public class CustomerUiController {

    private final CustomerService service;
    private final GuideTourService guideTourService;
    private final GuideService guideService;
  

    public CustomerUiController(CustomerService service, GuideTourService guideTourService, GuideService guideService) {
        this.service = service;
        this.guideTourService = guideTourService;
        this.guideService = guideService;
    }

    @GetMapping({"/"})
    public String viewLoginPage() {
        return "/index/login";
    }

    @GetMapping("/customers/customer-dash")
    public String viewCustomerDashboard(@RequestParam(required = false) String tourCity,
      @RequestParam(required = false) String tourState, Model model) {
        model.addAttribute("guideTours", guideTourService.searchGuideTours(null, tourCity, tourState));
        model.addAttribute("tourCity", tourCity == null ? "" : tourCity);
        model.addAttribute("tourState", tourState == null ? "" : tourState);
        return "/customer/customer-dash";
    }

    @GetMapping("/guideTours/{id}")
  public String details(@PathVariable Long id, Model model) {
    try {
      GuideTour guideTour = guideTourService.getGuideTourById(id);
      model.addAttribute("guideTour", guideTour);
      return "customer/customer-nature-tour";
    } catch (RuntimeException exception) {
      model.addAttribute("errorMessage",
          exception.getMessage() == null ? "Guide tour not found" : exception.getMessage());
      return "error";
    }
  }

    @GetMapping("/customers/customer-login")
    public String viewCustomerLoginPage() {
        return "/customer/customer-login";
    }

    
    @PostMapping ("/customers/customer-login")
    public String handleCustomerLogin(@RequestParam String email, @RequestParam String password, Model model) {
        try {
            Customer customer = service.authenticateCustomer(email, password);
            return "redirect:/customers/" + customer.getId();
        } catch (RuntimeException exception) {
            model.addAttribute("errorMessage",
                    exception.getMessage() == null ? "Invalid email or password" : exception.getMessage());
            return "/customer/customer-login";
        }
    }
      

    @GetMapping("/customers/customer-registration")
    public String viewCustomerRegistrationPage(Model model) {
          Customer customer = new Customer();
    model.addAttribute("customer", customer);
    model.addAttribute("formTitle", "Add a Customer");
    model.addAttribute("formAction", "/customers");
        return "/customer/customer-registration";
    }


    /*
    @GetMapping("/{id}/customer-edit-profile.html")
    public String editCustomerProfile(@PathVariable Long id, Model model) {
        // Fetch the customer by ID and add to the model
        // Customer customer = customerService.findById(id);
        // model.addAttribute("customer", customer);
        return "customer/customer-edit-profile";
    }
    */

    @GetMapping("/customers/{id}")
    public String viewCustomerProfile(@PathVariable Long id, Model model) {
       try {
      Customer customer = service.getCustomerById(id);
      model.addAttribute("customer", customer);
      return "/customer/customer-profile";
    } catch (RuntimeException exception) {
      model.addAttribute("errorMessage",
          exception.getMessage() == null ? "Customer not found" : exception.getMessage());
      return "./shared/error";
    }
    }

@PostMapping("/customers")
  public String createCustomer(@Valid @ModelAttribute Customer customer) {
    Customer createdCustomer = service.createCustomer(customer);
    return "redirect:/customers/" + createdCustomer.getId();
  }

  @GetMapping("/customers/{id}/edit")
  public String editForm(@PathVariable() Long id, Model model) {
    Customer customer = service.getCustomerById(id);
    model.addAttribute("customer", customer);
    model.addAttribute("formTitle", "Edit Customer");
    model.addAttribute("formAction", "/customers/" + id);
    return "/customer/customer-edit-profile";
  }

  @PostMapping("/customers/{id}")
  public String updateCustomer(@PathVariable Long id, @Valid @ModelAttribute Customer customer) {
    Customer updatedCustomer = service.updateCustomer(id, customer);
    return "redirect:/customers/" + updatedCustomer.getId();
  }

  @PostMapping("/customers/{id}/delete")
  public String deleteCustomer(@PathVariable Long id) {
    service.deleteCustomer(id);
    return "redirect:/customers/customer-registration";
  }


}