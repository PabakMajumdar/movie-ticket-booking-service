package org.ticket.booking.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class State {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "state")
    private List<Theatre> theaters;

    @Id
    private Integer state_id;
    private String state_name;



}
