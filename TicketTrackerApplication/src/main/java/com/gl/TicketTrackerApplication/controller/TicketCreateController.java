package com.gl.TicketTrackerApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.TicketTrackerApplication.entity.Ticket;

@Controller
public class TicketCreateController {

	@RequestMapping("/tickets/add")
	public String addTicket(Model theModel) {
		Ticket theTicket = new Ticket();
		theModel.addAttribute("ticket", theTicket);
		theModel.addAttribute("formType", "Add New Ticket");
		return "formTicket";
	}
}
