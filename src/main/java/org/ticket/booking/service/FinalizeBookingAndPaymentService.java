package org.ticket.booking.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticket.booking.entity.Auditorium;
import org.ticket.booking.entity.CustomerBooking;
import org.ticket.booking.entity.Show;
import org.ticket.booking.repository.CustomerBookingRepository;

@Service
public class FinalizeBookingAndPaymentService {

    @Autowired
    CustomerBookingRepository customerBookingRepository;


    public CustomerBooking finalizeBooking(Show selectedShow,String customerName,Integer noFSeats){

        CustomerBooking customerBooking=
                new CustomerBooking(customerName,selectedShow.getAuditorium().getScreen_id(),
                        selectedShow.getAuditorium().getSection(),noFSeats);

        return customerBookingRepository.save(customerBooking);
    }

    public Double calculateTicketPrice(Auditorium auditorium,CustomerBooking booking){
        return auditorium.getPrice()*booking.getNoOFSeats();
    }
}
