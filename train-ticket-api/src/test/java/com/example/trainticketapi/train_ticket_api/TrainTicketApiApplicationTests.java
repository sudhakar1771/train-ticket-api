package com.example.trainticketapi.train_ticket_api;

import com.example.trainticketapi.train_ticket_api.model.User;
import com.example.trainticketapi.train_ticket_api.service.TicketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TrainTicketApiApplicationTests {

	@Autowired
	private TicketService ticketService;

	@Test
	void contextLoads() {
	}

	@Test
	void testPurchaseTicket() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setEmail("john.doe@example.com");

		var ticket = ticketService.purchaseTicket(user);

		Assertions.assertNotNull(ticket);
		Assertions.assertEquals(ticket.getUser().getFirstName(),"John");
	}

}
