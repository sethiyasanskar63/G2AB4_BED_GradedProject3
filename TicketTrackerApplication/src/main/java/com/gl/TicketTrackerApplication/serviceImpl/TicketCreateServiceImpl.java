package com.gl.TicketTrackerApplication.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.TicketTrackerApplication.entity.Ticket;
import com.gl.TicketTrackerApplication.repository.TicketRepository;
import com.gl.TicketTrackerApplication.service.TicketCreateService;

@Service
public class TicketCreateServiceImpl implements TicketCreateService {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public void addSingleTicket(Ticket ticket) {
		ticketRepository.saveAndFlush(ticket);
	}

}
