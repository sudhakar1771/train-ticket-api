package com.example.trainticketapi.train_ticket_api.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
