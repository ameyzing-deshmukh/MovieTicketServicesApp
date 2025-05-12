package com.movieticketmgmt.service;

import com.movieticketmgmt.dto.Movie;
import com.movieticketmgmt.dto.Ticket;
import com.movieticketmgmt.entity.MovieEntity;
import com.movieticketmgmt.entity.TicketEntity;
import com.movieticketmgmt.exception.InvalidMovieIdException;
import com.movieticketmgmt.exception.InvalidTicketIdException;
import com.movieticketmgmt.repository.MovieEntityRepo;
import com.movieticketmgmt.repository.TicketEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieEntityRepo movieRepo;

    @Autowired
    private TicketEntityRepo ticketRepo;

    public MovieEntity createMovie(Movie dto) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(dto.title);
        movieEntity.setDirector(dto.director);
        movieEntity.setLanguage(dto.language);
        movieEntity.setYear(dto.year);
        return movieRepo.save(movieEntity);
    }

    public MovieEntity getMovie(Long id) {
        return movieRepo.findById(id)
                .orElseThrow(() -> new InvalidMovieIdException("Movie ID not found: " + id));
    }

    public TicketEntity bookTicket(Long movieId, Ticket dto) {
        if (dto.title == null || dto.title.trim().isEmpty() || dto.type == null || dto.type.trim().isEmpty()) {
            throw new IllegalArgumentException("Title and Type must not be blank");
        }

        MovieEntity movieEntity = getMovie(movieId);
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setTitle(dto.title);
        ticketEntity.setType(dto.type);
        ticketEntity.setUnitPrice(dto.unitPrice);
        ticketEntity.setNoOfTickets(dto.noOfTickets);
        ticketEntity.setPrice(dto.unitPrice * dto.noOfTickets);
        ticketEntity.setMovie(movieEntity);

        return ticketRepo.save(ticketEntity);
    }

    public TicketEntity getTicket(Long id) {
        return ticketRepo.findById(id)
                .orElseThrow(() -> new InvalidTicketIdException("Ticket ID not found: " + id));
    }

    public List<TicketEntity> getTicketsByMovieId(Long movieId) {
        if (!movieRepo.existsById(movieId)) {
            throw new InvalidMovieIdException("Movie ID not found: " + movieId);
        }
        return ticketRepo.findByMovie_MovieId(movieId);
    }
}

