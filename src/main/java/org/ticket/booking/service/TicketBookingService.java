package org.ticket.booking.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticket.booking.entity.Auditorium;
import org.ticket.booking.entity.CustomerBooking;
import org.ticket.booking.entity.Show;
import org.ticket.booking.repository.ShowRepository;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TicketBookingService {

    @Autowired
    private TicketBookingService bookingService;

    @Autowired
    private ShowCapacityUpdateService showCapacityUpdateService;

    @Autowired
    private FinalizeBookingAndPaymentService finalizeBookingAndPaymentService;


    @Autowired
    ShowRepository repository;

    public List<Show> filterTheatres(String movieName, String city, Date showDate){
       return repository.filterTheatres(movieName,city,showDate);
    }
    public Show selectScreen(String theatreName, Time showTime){
       return  repository.selectScreen(theatreName,showTime);
    }

 @Transactional(rollbackOn = Exception.class)
 public Map<Show,Double> bookShow(String theatreName,Time showTime,Integer seats,String customerName){
     Show selectedShow=bookingService.selectScreen(theatreName,showTime);
     CustomerBooking booking= finalizeBookingAndPaymentService.finalizeBooking(selectedShow,customerName,seats);
     //need to update auditorium capacity for Show after seat booking by Customer
     Auditorium auditorium=showCapacityUpdateService.updateCapacityOfShow(booking,selectedShow);
     Double ticketAmount=finalizeBookingAndPaymentService.
             calculateTicketPrice(auditorium,booking);
     Map<Show, Double> showDetails=new HashMap<Show, Double>();
     showDetails.put(selectedShow,ticketAmount);
     return showDetails;
 }


}
