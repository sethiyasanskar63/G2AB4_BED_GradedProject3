package com.gl.TicketTrackerApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.TicketTrackerApplication.entity.Ticket;
import com.gl.TicketTrackerApplication.serviceImpl.TicketReadServiceImpl;

@Controller
public class TicketReadController {

	@Autowired
	TicketReadServiceImpl ticketReadServiceImpl;

	@RequestMapping("/tickets/list")
	public String showAllTickets(Model theModel) {
		List<Ticket> theTickets = ticketReadServiceImpl.getTicketsSortedById();
		theModel.addAttribute("tickets", theTickets);
		return "listTickets";
	}

	@RequestMapping("/tickets/search")
	public String showTicketsWithThisTitle(@RequestParam("title") String title, Model theModel) {

		if (title.trim().isEmpty()) {
			return "redirect:/tickets/list";
		} else {
			List<Ticket> theTickets = ticketReadServiceImpl.getTicketsSortedByIdAndWithThisTitle(title);
			theModel.addAttribute("tickets", theTickets);
			return "listTickets";
		}
	}
}
