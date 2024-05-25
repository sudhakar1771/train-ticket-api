package com.example.trainticketapi.train_ticket_api.service;

import com.example.trainticketapi.train_ticket_api.exception.UserNotFoundException;
import com.example.trainticketapi.train_ticket_api.model.Ticket;
import com.example.trainticketapi.train_ticket_api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    private List<Ticket> tickets = new ArrayList<>();
    private List<String> sectionASeats = new ArrayList<>();
    private List<String> sectionBSeats = new ArrayList<>();

    public TicketService() {
        // Initialize seats
        for (int i = 1; i <= 50; i++) {
            sectionASeats.add("A" + i);
            sectionBSeats.add("B" + i);
        }
    }

    public Ticket purchaseTicket(User user) {
        String seat = sectionASeats.isEmpty() ? sectionBSeats.remove(0) : sectionASeats.remove(0);
        Ticket ticket = new Ticket();
        ticket.setFrom("London");
        ticket.setTo("France");
        ticket.setUser(user);
        ticket.setPrice(20.0);
        ticket.setSeat(seat);
        tickets.add(ticket);
        return ticket;
    }

    public Ticket getTicket(int id) {
        return tickets.stream().filter(t -> t.getId() == id).findFirst().orElseThrow(() -> new UserNotFoundException("Ticket not found"));
    }

    public List<Ticket> getUsersBySection(String section) {
        if (section.equalsIgnoreCase("A")) {
            return tickets.stream().filter(t -> t.getSeat().startsWith("A")).toList();
        } else if (section.equalsIgnoreCase("B")) {
            return tickets.stream().filter(t -> t.getSeat().startsWith("B")).toList();
        }
        return new ArrayList<>();
    }

    public void removeUser(int id) {
        Ticket ticket = getTicket(id);
        tickets.remove(ticket);
        if (ticket.getSeat().startsWith("A")) {
            sectionASeats.add(ticket.getSeat());
        } else {
            sectionBSeats.add(ticket.getSeat());
        }
    }

    public Ticket modifyUserSeat(int id, String newSeat) {
        Ticket ticket = getTicket(id);
        if (ticket.getSeat().startsWith("A")) {
            sectionASeats.add(ticket.getSeat());
        } else {
            sectionBSeats.add(ticket.getSeat());
        }
        ticket.setSeat(newSeat);
        if (newSeat.startsWith("A")) {
            sectionASeats.remove(newSeat);
        } else {
            sectionBSeats.remove(newSeat);
        }
        return ticket;
    }
}
