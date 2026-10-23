package com.example.LocalGuide.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.LocalGuide.entity.Customer;
import com.example.LocalGuide.service.CustomerService;
import com.example.LocalGuide.entity.Booking;
import com.example.LocalGuide.service.BookingService;
import com.example.LocalGuide.entity.Review;
import com.example.LocalGuide.service.ReviewService;





import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/api/customers")

public class CustomerController {
    
    private final CustomerService customerService;
    private final BookingService bookingService;
    private final ReviewService reviewService;

    public CustomerController(CustomerService customerService, BookingService bookingService, ReviewService reviewService) {
        this.customerService = customerService;
        this.bookingService = bookingService;
        this.reviewService = reviewService;
    }

    @GetMapping 
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping ("/search") 
    public List<Customer> searchCustomers(
            @RequestParam(required = false) String f_name,
            @RequestParam(required = false) String l_name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state) {
        return customerService.searchCustomers(f_name, l_name, email, city, state);
    }

    @GetMapping ("/{id}") 
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping 
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping ("/{id}") 
    public Customer updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer updatedCustomer) {
        return customerService.updateCustomer(id, updatedCustomer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping ("/{id}/bookings") 
    public List<Booking> getAllBookings(@PathVariable Long id) {
        return bookingService.getAllBookings();
    }

    /*
    @GetMapping ("/customers/{id}/bookings/{bookingId}") 
    public Booking getBookingById(@PathVariable Long id, Long bookingId) {
        return bookingService.getBookingById(id, bookingId);
    }
        */

    @GetMapping ("/{id}/reviews") 
    public List<Review> getAllReviews(@PathVariable Long id) {
        return reviewService.getAllReviews();
    }
}
