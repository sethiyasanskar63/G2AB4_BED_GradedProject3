package com.greatlearning.G2AB4_BED_GradedProject3.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.G2AB4_BED_GradedProject3.entity.Ticket;
import com.greatlearning.G2AB4_BED_GradedProject3.repository.TicketRepository;
import com.greatlearning.G2AB4_BED_GradedProject3.service.TicketCreateService;

@Service
public class TicketCreateServiceImpl implements TicketCreateService {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public void addSingleTicket(Ticket ticket) {
		ticketRepository.saveAndFlush(ticket);
	}
}
