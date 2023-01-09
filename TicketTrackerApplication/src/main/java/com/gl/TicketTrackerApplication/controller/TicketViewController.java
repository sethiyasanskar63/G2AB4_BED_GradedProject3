package com.gl.TicketTrackerApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.TicketTrackerApplication.entity.Ticket;
import com.gl.TicketTrackerApplication.serviceImpl.TicketReadServiceImpl;

@Controller
public class TicketViewController {

	@Autowired
	TicketReadServiceImpl ticketReadServiceImpl;

	@RequestMapping("/tickets/view")
	public String vierTicket(@RequestParam("id") Long id, Model theModel) {
		Ticket theTicket = ticketReadServiceImpl.getTicketById(id);
		theModel.addAttribute("ticket", theTicket);
		return "viewTicket";
	}
}
