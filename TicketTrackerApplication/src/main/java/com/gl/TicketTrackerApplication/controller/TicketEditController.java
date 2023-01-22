package com.gl.TicketTrackerApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.TicketTrackerApplication.entity.Ticket;
import com.gl.TicketTrackerApplication.serviceImpl.TicketReadServiceImpl;

@Controller
public class TicketEditController {

	@Autowired
	TicketReadServiceImpl ticketReadServiceImpl;

	@RequestMapping("/tickets/edit")
	public String editTicket(@RequestParam("id") Long id, Model theModel) {
		Ticket theTicket = ticketReadServiceImpl.getTicketById(id);
		theModel.addAttribute("ticket", theTicket);
		theModel.addAttribute("formType", "Edit Ticket");
		return "formTicket";
	}
}
