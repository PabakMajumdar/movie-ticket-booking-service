package org.ticket.booking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Entity
@AllArgsConstructor
@Getter
public class Country {

    public Country() {

    }

    @Id
    private Integer country_id;

   /* @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private List<State> states;*/

    @Column
    private String country_name;


}
