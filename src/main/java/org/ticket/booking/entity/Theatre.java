package org.ticket.booking.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Theatre {

    @Id
    private Integer theatre_id;

    private String theatre_name;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    private Integer country_id;

    private String address;


    @OneToMany(fetch = FetchType.LAZY)
    private List<Show> shows;


}
