package com.cinema.cinemaprojet.Repositories;

import com.cinema.cinemaprojet.Entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SeatRepository extends JpaRepository<Seat,Long> {
}
