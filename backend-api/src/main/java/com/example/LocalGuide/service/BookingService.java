package com.example.LocalGuide.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LocalGuide.entity.Booking;
import com.example.LocalGuide.entity.Timeslot;
import com.example.LocalGuide.repository.BookingRepository;

@Service
public class BookingService {
    
private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> searchBookings(String title, String location, String city, String state) {
        if (title != null && !title.isEmpty()) {
            return bookingRepository.findByTitleContainingIgnoreCase(title);
        } else if (city != null && !city.isEmpty() && state != null && !state.isEmpty()) {
            return bookingRepository.findByCityAndStateContainingIgnoreCase(city, state);
        } else if (city != null && !city.isEmpty()) {
            return bookingRepository.findByCityContainingIgnoreCase(city);
        } else if (state != null && !state.isEmpty()) {
            return bookingRepository.findByStateContainingIgnoreCase(state);
        } else if (location != null && !location.isEmpty()) {
            return bookingRepository.findByLocationContainingIgnoreCase(location); 
        }else {
            return bookingRepository.findAll();
        }
    }

     public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking existingBooking = bookingRepository.findById(id).orElse(null);
        if (existingBooking != null) {
            existingBooking.setCity(updatedBooking.getCity());
            existingBooking.setState(updatedBooking.getState());
            existingBooking.setLocation(updatedBooking.getLocation());
            existingBooking.setTitle(updatedBooking.getTitle());
            existingBooking.setDescription(updatedBooking.getDescription());
            return bookingRepository.save(existingBooking);
        }
        return null;
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

}
