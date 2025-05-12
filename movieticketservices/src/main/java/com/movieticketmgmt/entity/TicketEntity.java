package com.movieticketmgmt.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "ticket_entity")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @NotBlank
    private String title;

    @NotBlank
    private String type;

    @NotNull
    private Double unitPrice;

    @NotNull
    private Integer noOfTickets;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

    // Getters, Setters, Constructors

}
