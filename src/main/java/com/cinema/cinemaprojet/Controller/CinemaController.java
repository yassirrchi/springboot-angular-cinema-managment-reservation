package com.cinema.cinemaprojet.Controller;

import com.cinema.cinemaprojet.Entities.Movie;
import com.cinema.cinemaprojet.Entities.Ticket;
import com.cinema.cinemaprojet.Repositories.MovieRepository;
import com.cinema.cinemaprojet.Repositories.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class CinemaController {
    MovieRepository movieRepository;
    TicketRepository ticketRepository;
  /*  @GetMapping(value = "/image/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable (name = "id") Long id){
        Movie movie=movieRepository.findById(id).get();
        String photoName=movie.getTag();


    }*/


    @PostMapping("/ticket/pay")
  @Transactional
    public List<Ticket> pay(@RequestBody TicketForm ticketForm ){
        System.out.println(ticketForm.getTickets());
        List<Ticket> ticketsList=new ArrayList<>();
        ticketForm.getTickets().forEach(ticketId->{
            Ticket ticket=ticketRepository.findById(ticketId).get();
            ticket.setReserved(true);
            ticketRepository.save(ticket);
            ticketsList.add(ticket);
        });
        return ticketsList;

    }
}
@Data
class TicketForm{
    private String client;
    private int paymentCode;
    private List<Long> tickets=new ArrayList<>();
}
