package com.greatlearning.G2AB4_BED_GradedProject3.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.G2AB4_BED_GradedProject3.repository.TicketRepository;
import com.greatlearning.G2AB4_BED_GradedProject3.service.TicketDeleteService;

@Service
public class TicketDeleteServiceImpl implements TicketDeleteService {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public void deleteTicketById(int id) {
		ticketRepository.deleteById(id);
	}
}
