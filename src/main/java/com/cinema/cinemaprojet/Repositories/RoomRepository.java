package com.cinema.cinemaprojet.Repositories;

import com.cinema.cinemaprojet.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoomRepository extends JpaRepository<Room,Long> {
}
