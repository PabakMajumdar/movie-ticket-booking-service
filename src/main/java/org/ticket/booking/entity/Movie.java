package org.ticket.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Movie {

    @Id
    private Integer movie_id;

    private String movie_title;

    private Date releaseDate;

    private Long duration;

}
