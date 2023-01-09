package com.gl.TicketTrackerApplication.service;

import java.util.List;

import com.gl.TicketTrackerApplication.entity.Ticket;

public interface TicketReadService {

	List<Ticket> getTicketsSortedById();

	List<Ticket> getTicketsSortedByIdAndWithThisTitle(String title);

	Ticket getTicketById(Long id);

}