package org.ticket.booking.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ticket.booking.entity.CustomerBooking;

@Repository
public interface CustomerBookingRepository extends JpaRepository<CustomerBooking, Id> {
}
