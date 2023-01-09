package com.gl.TicketTrackerApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.TicketTrackerApplication.serviceImpl.TicketDeleteServiceImpl;

@Controller
public class TicketDeleteController {

	@Autowired
	TicketDeleteServiceImpl ticketDeleteServiceImpl;

	@RequestMapping("/tickets/delete")
	public String deleteTicketById(@RequestParam("id") Long id) {
		ticketDeleteServiceImpl.deleteTicketById(id);
		return "redirect:/tickets/list";
	}
}
