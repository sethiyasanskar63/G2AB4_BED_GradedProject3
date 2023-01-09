package com.gl.TicketTrackerApplication.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.TicketTrackerApplication.entity.Ticket;
import com.gl.TicketTrackerApplication.serviceImpl.TicketCreateServiceImpl;
import com.gl.TicketTrackerApplication.serviceImpl.TicketReadServiceImpl;

@Controller
public class TicketSaveController {

	@Autowired
	TicketReadServiceImpl ticketReadServiceImpl;

	@Autowired
	TicketCreateServiceImpl ticketCreateServiceImpl;

	@PostMapping("/tickets/save")
	public String saveTicket(@RequestParam("id") Long id, @RequestParam("title") String title,
			@RequestParam("shortDescription") String shortDescription, @RequestParam("content") String content) {

		Ticket theTicket;
		if (id != 0) {
			theTicket = ticketReadServiceImpl.getTicketById(id);
			theTicket.setTitle(title);
			theTicket.setShortDescription(shortDescription);
			theTicket.setContent(content);
		} else {
			LocalDate localDate = LocalDate.now();
			theTicket = Ticket.builder().title(title).content(content).shortDescription(shortDescription)
					.createdOn(localDate).build();
		}
		ticketCreateServiceImpl.addSingleTicket(theTicket);
		return "redirect:/tickets/list";
	}
}
