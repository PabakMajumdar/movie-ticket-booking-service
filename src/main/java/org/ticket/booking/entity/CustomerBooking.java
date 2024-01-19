package org.ticket.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Getter

public class CustomerBooking {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer customer_id;

    private String customer_name;

    private Integer screen_id;

    private String section;

    private Integer noOFSeats;

    public CustomerBooking(String name,Integer screen_id,String section,Integer noOFSeats){
        this.customer_name=name;
        this.screen_id=screen_id;
        this.section=section;
        this.noOFSeats=noOFSeats;

    }


    public CustomerBooking() {

    }
}
