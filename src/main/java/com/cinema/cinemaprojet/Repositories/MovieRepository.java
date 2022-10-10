package com.cinema.cinemaprojet.Repositories;

import com.cinema.cinemaprojet.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MovieRepository extends JpaRepository<Movie,Long> {
}
