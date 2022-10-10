package com.cinema.cinemaprojet.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Cinema cinema;
    @OneToMany(mappedBy = "room")
    private Collection<Seat> seats;
    @OneToMany
    private Collection<Projection> projections;




}
