package com.example.trainticketapi.train_ticket_api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {

    private static int idCounter = 1;

    private int id;
    private String from;
    private String to;
    private User user;
    private double price;
    private String seat;

    public Ticket() {
        this.id = idCounter++;
    }
}
