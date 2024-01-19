package org.ticket.booking.controller;


import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.ticket.booking.entity.Auditorium;
import org.ticket.booking.entity.CustomerBooking;
import org.ticket.booking.entity.Show;
import org.ticket.booking.service.FinalizeBookingAndPaymentService;
import org.ticket.booking.service.ShowCapacityUpdateService;
import org.ticket.booking.service.TicketBookingService;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@RestController
public class TicketBookingController {

   @Autowired
    private TicketBookingService bookingService;
   private Map<String, Time> showsWithTiming;


@PostMapping("/getShows")
    public ResponseEntity<Map<String,Time>> getTheatres
            (@RequestParam("movie") String movie,@RequestParam("city") String city,
             @RequestParam("date") Date date){

       List<Show> shows= bookingService.filterTheatres(movie,city,date);

       for(Show s:shows)
           showsWithTiming.put(s.getTheatre().getTheatre_name(),s.getShowTiming());

       return new ResponseEntity<Map<String,Time>>(showsWithTiming,HttpStatus.OK);
    }
@PostMapping("/bookShow")
public ResponseEntity<Map<Show, Double>> bookShow(@RequestParam("theatre_name") String theatreName,
                                                       @RequestParam("show_time") Time showTime, @RequestParam("noOfSeats") Integer seats
        , @RequestParam("customerName") String customerName){

    Map<Show, Double> showDetails=bookingService.bookShow(theatreName,showTime,seats,customerName);
    return new ResponseEntity<>(showDetails,HttpStatus.OK);
}
}
