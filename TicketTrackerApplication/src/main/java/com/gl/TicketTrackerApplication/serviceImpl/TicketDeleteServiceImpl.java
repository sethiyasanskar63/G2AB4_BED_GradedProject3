package com.gl.TicketTrackerApplication.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.TicketTrackerApplication.repository.TicketRepository;
import com.gl.TicketTrackerApplication.service.TicketDeleteService;

@Service
public class TicketDeleteServiceImpl implements TicketDeleteService {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public void deleteTicketById(long id) {
		ticketRepository.deleteById(id);
	}
}
