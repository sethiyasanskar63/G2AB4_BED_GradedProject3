package com.gl.TicketTrackerApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String showTickets() {
		return "redirect:/tickets/list";
	}
}
