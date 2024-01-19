package org.ticket.booking.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ticket.booking.entity.Country;
import org.ticket.booking.service.RegistrationService;

import java.util.Map;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService service;

    @PostMapping("/createCountry")
    public ResponseEntity<String>  createCountry(){
        Country country =new Country(1,"India");
      String countryCreated=  service.createCountry(country);
      return new ResponseEntity<>
              ("Country" + countryCreated + "created successfully", HttpStatus.OK);
    }
}
