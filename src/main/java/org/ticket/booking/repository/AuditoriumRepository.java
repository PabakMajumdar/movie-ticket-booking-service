package org.ticket.booking.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.ticket.booking.entity.Auditorium;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Id> {

    //update auditorium capacity for bookings done for shows
    @Query("update Auditorium  a set a.capacity =a.capacity -:seats where a.show.showId= :show and a.screen_id=" +
            " :screenID ")
    public Auditorium updateAuditoriumByCapacity(@Param("seats") Integer noOfSeats
            ,@Param("show") Integer showId ,@Param("screenID") Integer screenID);



}
