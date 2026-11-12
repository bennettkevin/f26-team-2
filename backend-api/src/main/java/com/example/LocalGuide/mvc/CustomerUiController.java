package com.example.LocalGuide.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.LocalGuide.service.CustomerService;
import com.example.LocalGuide.entity.Customer;

@Controller
//@RequestMapping("/customer")
public class CustomerUiController {

    private final CustomerService service;

    public CustomerUiController(CustomerService service) {
        this.service = service;
    }

    @GetMapping({"/", "/customers"})
    public String viewLoginPage() {
        return "/index/login";
    }

    @GetMapping("/customers/customer-login")
    public String viewCustomerLoginPage() {
        return "/customer/customer-login";
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
      return "/shared/error";
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