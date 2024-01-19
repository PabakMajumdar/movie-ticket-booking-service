package org.ticket.booking.entity;


import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
public class Show {

    @Id
    @GeneratedValue
    private Integer showId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatreId")
    private Theatre theatre;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movieId")
    private Movie movie;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="screenId")
    private Auditorium auditorium;

    private Time showTiming;

    private Date showDate;


}
