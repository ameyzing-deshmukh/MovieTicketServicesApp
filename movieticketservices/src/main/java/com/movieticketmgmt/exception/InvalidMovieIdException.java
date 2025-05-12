package com.movieticketmgmt.exception;

public class InvalidMovieIdException extends RuntimeException {
    public InvalidMovieIdException(String msg) {
        super(msg);
    }
}
