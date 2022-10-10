package com.cinema.cinemaprojet.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String director;
    private Date releaseDate;
    private double duration;
    private String tag;
    @OneToMany(mappedBy = "movie")
    private Collection<Projection> projections;
    @ManyToOne
    private Category category;



}
