package com.example.LocalGuide.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LocalGuide.entity.Customer;
import com.example.LocalGuide.repository.CustomerRepository;
import com.example.LocalGuide.entity.Booking;
import com.example.LocalGuide.repository.BookingRepository;

@Service 
public class CustomerService {
    private final CustomerRepository repository;
    private final BookingRepository bookingRepository;

    public CustomerService(CustomerRepository repository, BookingRepository bookingRepository) {
        this.repository = repository;
        this.bookingRepository = bookingRepository;
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public List<Customer> searchCustomers(String f_name, String l_name, String email, String city, String state) {
        if (f_name != null && !f_name.isEmpty()) {
            return repository.findByFirstNameContainingIgnoreCase(f_name);
        } else if (l_name != null && !l_name.isEmpty()) {
            return repository.findByLastNameContainingIgnoreCase(l_name);
        } else if (email != null && !email.isEmpty()) {
            return repository.findByEmailContainingIgnoreCase(email);
        } else if (city != null && !city.isEmpty() && state != null && !state.isEmpty()) {
            return repository.findByCityAndStateContainingIgnoreCase(city, state);
        } else if (city != null && !city.isEmpty()) {
            return repository.findByCityContainingIgnoreCase(city);
        } else if (state != null && !state.isEmpty()) {
            return repository.findByStateContainingIgnoreCase(state);
        } else {
            return repository.findAll();
        }
    }

    public Customer getCustomerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existingCustomer = repository.findById(id).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setFName(updatedCustomer.getFName());
            existingCustomer.setLName(updatedCustomer.getLName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setPassword(updatedCustomer.getPassword());
            existingCustomer.setCity(updatedCustomer.getCity());
            existingCustomer.setState(updatedCustomer.getState());
            existingCustomer.setBio(updatedCustomer.getBio());
            existingCustomer.setProfilePicture(updatedCustomer.getProfilePicture());
            existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            return repository.save(existingCustomer);
        }
        return null;
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

    public void getBookings(Long id){
        bookingRepository.findAllByCustomerIdOrderByIdDesc(id);
    }
}
