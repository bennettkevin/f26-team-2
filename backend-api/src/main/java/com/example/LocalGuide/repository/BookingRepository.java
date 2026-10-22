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

    List<Booking> findAllByGuideIdOrderByIdDesc(Long guideId);

    List<Booking> findByTitleContainingIgnoreCase(String title);

    List<Booking> findByStateContainingIgnoreCase(String state);

    List<Booking> findByLocationContainingIgnoreCase(String location);

    List<Booking> findByCityContainingIgnoreCase(String city);

    List<Booking> findByCityAndStateContainingIgnoreCase(String city, String state);



    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select booking from Booking booking "
            + "where booking.id = :id")
    Optional<Booking> findByIdForUpdate(@Param("id") Long id);
}
