package com.cinema.cinemaprojet;

import com.cinema.cinemaprojet.Services.CinemaServices;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class CinemaProjetApplication implements CommandLineRunner {
    private CinemaServices cinemaServices;

    public static void main(String[] args) {
        SpringApplication.run(CinemaProjetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cinemaServices.citiesInit();
        cinemaServices.cinemasInit();
        cinemaServices.roomsInit();
        cinemaServices.seatsInit();
        cinemaServices.sessionsInit();
        cinemaServices.categoriesInit();
        cinemaServices.moviesInit();
        cinemaServices.projectionsInit();
        cinemaServices.ticketsInit();

    }
}
