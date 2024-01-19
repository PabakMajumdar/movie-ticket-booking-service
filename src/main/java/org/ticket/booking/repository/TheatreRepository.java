package org.ticket.booking.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ticket.booking.entity.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Id> {
}
