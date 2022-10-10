package com.cinema.cinemaprojet.Repositories;

import com.cinema.cinemaprojet.Entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SessionRepository extends JpaRepository<Session,Long> {
}
