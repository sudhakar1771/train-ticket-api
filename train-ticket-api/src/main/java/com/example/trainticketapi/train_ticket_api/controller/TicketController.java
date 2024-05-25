package com.example.trainticketapi.train_ticket_api.controller;

import com.example.trainticketapi.train_ticket_api.model.Ticket;
import com.example.trainticketapi.train_ticket_api.model.User;
import com.example.trainticketapi.train_ticket_api.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/purchase")
    public Ticket purchaseTicket(@RequestBody User user) {
        return ticketService.purchaseTicket(user);
    }

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable int id) {
        return ticketService.getTicket(id);
    }

    @GetMapping("/section/{section}")
    public List<Ticket> getUsersBySection(@PathVariable String section) {
        return ticketService.getUsersBySection(section);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable int id) {
        ticketService.removeUser(id);
    }

    @PutMapping("/{id}/seat")
    public Ticket modifyUserSeat(@PathVariable int id, @RequestParam String seat) {
        return ticketService.modifyUserSeat(id, seat);
    }
}
