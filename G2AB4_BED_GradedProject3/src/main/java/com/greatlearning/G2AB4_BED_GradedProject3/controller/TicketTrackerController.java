package com.greatlearning.G2AB4_BED_GradedProject3.controller;

import com.greatlearning.G2AB4_BED_GradedProject3.entity.Ticket;
import com.greatlearning.G2AB4_BED_GradedProject3.serviceImpl.TicketCreateServiceImpl;
import com.greatlearning.G2AB4_BED_GradedProject3.serviceImpl.TicketDeleteServiceImpl;
import com.greatlearning.G2AB4_BED_GradedProject3.serviceImpl.TicketReadServiceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tickets")
public class TicketTrackerController {

	@Autowired
	TicketReadServiceImpl ticketReadServiceImpl;

	@Autowired
	TicketCreateServiceImpl ticketCreateServiceImpl;

	@Autowired
	TicketDeleteServiceImpl ticketDeleteServiceImpl;

	@RequestMapping("/")
	public String showTickets(Model theModel) {

		List<Ticket> theTickets = ticketReadServiceImpl.getTicketsSortedById();
		theModel.addAttribute("tickets", theTickets);
		return "tickets";
	}

	@RequestMapping("/newticket/")
	public String newTicket(Model theModel) {

		Ticket theTicket = new Ticket();
		theModel.addAttribute("tickets", theTicket);
		return "createticket";
	}

	@RequestMapping("/edit")
	public String editTicket(@RequestParam("id") String iD, Model theModel) {

		int id = Integer.valueOf(iD);
		ticketReadServiceImpl.getTicketById(id);
		Ticket theTicket = ticketReadServiceImpl.getTicketById(id);
		theModel.addAttribute("tickets", theTicket);
		return "editticket";
	}

	@RequestMapping("/search")
	public String newSearch(@RequestParam("title") String title, Model theModel) {

		if (title.trim().isEmpty()) {
			return "redirect:/tickets/";
		} else {

			List<Ticket> theTickets = ticketReadServiceImpl.getTicketsSortedByIdAndWithThisTitle(title);
			theModel.addAttribute("tickets", theTickets);
			return "tickets";
		}
	}

	@PostMapping("/save")
	public String saveTicket(@RequestParam("id") int id, @RequestParam("title") String title,
			@RequestParam("shortDescription") String shortDescription, @RequestParam("content") String content) {

		Ticket theTicket;
		if (id != 0) {
			theTicket = ticketReadServiceImpl.getTicketById(id);
			theTicket.setTitle(title);
			theTicket.setContent(content);
			theTicket.setShortDescription(shortDescription);
		} else {
			LocalDate date = LocalDate.now();
			theTicket = Ticket.builder().title(title).content(content).shortDescription(shortDescription)
					.createdOn(date).build();
		}
		ticketCreateServiceImpl.addSingleTicket(theTicket);
		return "redirect:/tickets/";
	}

	@RequestMapping("/delete")
	public String deleteTicket(@RequestParam("id") int id) {
		ticketDeleteServiceImpl.deleteTicketById(id);
		return "redirect:/tickets/";
	}

	@RequestMapping("/view")
	public String viewTicket(@RequestParam("id") int id, Model theModel) {
		Ticket theTicket = ticketReadServiceImpl.getTicketById(id);
		theModel.addAttribute("ticket", theTicket);
		return "viewticket";
	}

}
