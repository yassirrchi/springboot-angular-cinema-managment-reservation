package com.cinema.cinemaprojet.Entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientName;
    private double price;
    private int paymentCode;
    private boolean reserved;
    @ManyToOne
    private Seat seat;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    private Projection projection;





}
