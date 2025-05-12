package com.movieticketmgmt.repository;


import com.movieticketmgmt.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieEntityRepo extends JpaRepository<MovieEntity, Long> {
}

