package com.greatlearning.G2AB4_BED_GradedProject3.service;

import java.util.List;

import com.greatlearning.G2AB4_BED_GradedProject3.entity.Ticket;

public interface TicketReadService {

	List<Ticket> getTicketsSortedById();

	List<Ticket> getTicketsSortedByIdAndWithThisTitle(String title);

	Ticket getTicketById(int id);

}