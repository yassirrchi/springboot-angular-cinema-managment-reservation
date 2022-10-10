package com.cinema.cinemaprojet.Services;

import com.cinema.cinemaprojet.Entities.*;
import com.cinema.cinemaprojet.Repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Transactional
public class CinemaServicesImpl implements CinemaServices {
    private CityRepository cityRepository;
    private CinemaRepository cinemaRepository;
    private RoomRepository roomRepository;
    private SeatRepository seatRepository;
    private SessionRepository sessionRepository;
    private MovieRepository movieRepository;
    private ProjectionRepository projectionRepository;
    private CategoryRepository categoryRepository;
    private TicketRepository ticketRepository;


    @Override
    public void citiesInit() {
        Stream.of("Casablanca","Rabat","Marrakech")
                .forEach(cityName->{
                    City city=new City();
                    city.setName(cityName);
                    cityRepository.save(city);
                });


    }

    @Override
    public void cinemasInit() {
        cityRepository.findAll().forEach(city -> {
            Stream.of("AMC","CINEMARK","REGAL CINEMA")
                    .forEach(cinemaName->{
                        Cinema cinema=new Cinema();
                        cinema.setName(cinemaName +" of "+city.getName());
                        cinema.setCity(city);
                        cinema.setNumberOfRooms(3+(int)(Math.random()*10));
                        cinemaRepository.save(cinema);


                    });

        });

    }

    @Override
    public void roomsInit() {
        cinemaRepository.findAll().forEach(cinema -> {
            for(int i=0;i<cinema.getNumberOfRooms();i++){
                Room room=new Room();
                room.setName("Room "+i+1);
                room.setCinema(cinema);
                room.setNumberOfSeats(20+(int)(Math.random()*30));
                roomRepository.save(room);



            }


        });

    }

    @Override
    public void seatsInit() {
        roomRepository.findAll().forEach(room-> {
            for(int i=0;i<room.getNumberOfSeats();i++){
                Seat seat=new Seat();
                seat.setNumero(i+1);
                seat.setRoom(room);
                seatRepository.save(seat);
            }
        });

    }

    @Override
    public void sessionsInit() {
        DateFormat dateFormat=new SimpleDateFormat("HH:mm");
        Stream.of("12:00","03:00","05:00","09:00").forEach(d->{
            Session session =new Session();
            try {
                session.setStartDate(dateFormat.parse(d));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            sessionRepository.save(session);
        });

    }

    @Override
    public void moviesInit() {
        List<Category> categories=categoryRepository.findAll();
        Stream.of("Iron Man","Shrek","Annihilation","El Camino")
                .forEach(movieName->{
                    Movie movie =new Movie();
                    movie.setName(movieName);
                    movie.setDuration(1.1+Math.random());
                    movie.setCategory(categories.get(new Random().nextInt(categories.size())));
                    movieRepository.save(movie);

                });

    }

    @Override
    public void projectionsInit() {
        List<Integer> prices= Arrays.asList(50,60,65,70);
        cityRepository.findAll().forEach(city -> {
            city.getCinemas().forEach(cinema -> {
                cinema.getRooms().forEach(room -> {
                    movieRepository.findAll()
                            .forEach(movie -> {
                                sessionRepository.findAll()
                                        .forEach(session -> {
                                            Projection projection=new Projection();
                                            projection.setProjectionDate(new Date());
                                            projection.setMovie(movie);
                                            projection.setPrice(prices.get((int) (Math.random() * (3 - 0))));
                                            projection.setRoom(room);
                                            projection.setSession(session);
                                            projectionRepository.save(projection);
                                        });
                            });
                });
            });
        });

    }

    @Override
    public void ticketsInit() {
        projectionRepository.findAll().forEach(projection -> {
            projection.getRoom().getSeats().forEach(seat ->
            {
                Ticket ticket=new Ticket();
                ticket.setSeat(seat);
                ticket.setPrice(projection.getPrice());
                ticket.setProjection(projection);
                ticket.setReserved(false );
                ticketRepository.save(ticket);

            });
        });

    }

    @Override
    public void categoriesInit() {
        Stream.of("Action","Drama","Fiction","Horror").forEach(categoryName ->{
            Category category=new Category();
            category.setName(categoryName);
            categoryRepository.save(category);
        });

    }
}
