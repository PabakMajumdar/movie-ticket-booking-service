package org.ticket.booking.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.ticket.booking.entity.Auditorium;
import org.ticket.booking.entity.CustomerBooking;
import org.ticket.booking.entity.Show;
import org.ticket.booking.repository.AuditoriumRepository;

@Service
public class ShowCapacityUpdateService {

    @Autowired
    private AuditoriumRepository auditoriumRepository;


    public Auditorium updateCapacityOfShow(CustomerBooking booking, Show bookedShow){
       return auditoriumRepository.updateAuditoriumByCapacity(booking.getNoOFSeats()
                ,bookedShow.getShowId(),bookedShow.getAuditorium().getScreen_id());
    }
}
