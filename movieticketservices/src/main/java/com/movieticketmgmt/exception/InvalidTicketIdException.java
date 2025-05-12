package com.movieticketmgmt.exception;

public class InvalidTicketIdException extends RuntimeException {
    public InvalidTicketIdException(String msg) {
        super(msg);
    }
}