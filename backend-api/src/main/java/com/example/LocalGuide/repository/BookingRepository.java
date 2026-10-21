package com.example.LocalGuide.repository;

import com.example.LocalGuide.entity.Booking;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByCustomerIdOrderByIdDesc(Long customerId);

    List<Booking> findAllByBooking_Guide_IdOrderByIdDesc(Long trainerId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select booking from Booking booking "
            + "where booking.id = :id")
    Optional<Booking> findByIdForUpdate(@Param("id") Long id);
}
