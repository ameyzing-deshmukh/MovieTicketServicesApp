package com.movieticketmgmt.repository;

import com.movieticketmgmt.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketEntityRepo extends JpaRepository<TicketEntity, Long> {
    List<TicketEntity> findByMovie_MovieId(Long id);
}
