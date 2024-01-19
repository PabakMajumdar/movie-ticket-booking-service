package org.ticket.booking.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;


@Entity
@Getter
public class Auditorium {

    @Id
    private Integer screen_id;

    private String section;

    private Integer capacity;

    private Double price;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "auditorium")
    private Show show;
}
