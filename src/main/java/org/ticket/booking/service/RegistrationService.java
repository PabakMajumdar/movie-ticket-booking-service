package org.ticket.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticket.booking.entity.Country;
import org.ticket.booking.repository.RegistrationRepository;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public String createCountry(Country country){
        Country createdCountry=registrationRepository.save(country);
        return createdCountry.getCountry_name();
    }
}
