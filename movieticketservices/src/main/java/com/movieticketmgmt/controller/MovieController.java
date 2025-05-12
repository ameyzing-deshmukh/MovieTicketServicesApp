package com.movieticketmgmt.controller;

import com.movieticketmgmt.dto.Movie;
import com.movieticketmgmt.dto.Ticket;
import com.movieticketmgmt.entity.MovieEntity;
import com.movieticketmgmt.entity.TicketEntity;
import com.movieticketmgmt.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping("/movies")
    public ResponseEntity<MovieEntity> createMovie(@RequestBody Movie dto) {
        return new ResponseEntity<>(service.createMovie(dto), HttpStatus.CREATED);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieEntity> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(service.getMovie(id));
    }

    @PostMapping("/movies/{movieId}/tickets")
    public ResponseEntity<TicketEntity> bookTicket(@PathVariable Long movieId, @RequestBody Ticket dto) {
        return new ResponseEntity<>(service.bookTicket(movieId, dto), HttpStatus.CREATED);
    }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<TicketEntity> getTicket(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTicket(id));
    }

    @GetMapping("/movies/{movieId}/tickets")
    public ResponseEntity<List<TicketEntity>> getTicketsByMovie(@PathVariable Long movieId) {
        return ResponseEntity.ok(service.getTicketsByMovieId(movieId));
    }
}
