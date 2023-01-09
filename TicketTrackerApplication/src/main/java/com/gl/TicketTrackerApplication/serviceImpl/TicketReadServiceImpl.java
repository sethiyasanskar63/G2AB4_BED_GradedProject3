package com.gl.TicketTrackerApplication.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gl.TicketTrackerApplication.entity.Ticket;
import com.gl.TicketTrackerApplication.repository.TicketRepository;
import com.gl.TicketTrackerApplication.service.TicketReadService;

@Service
public class TicketReadServiceImpl implements TicketReadService {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Ticket> getTicketsSortedById() {
		return ticketRepository.findAll(Sort.by(Direction.ASC, "id"));
	}

	@Override
	public List<Ticket> getTicketsSortedByIdAndWithThisTitle(String title) {

		Ticket ticketWithThisTitleTicket = Ticket.builder().title(title).build();

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("title", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "shortDescription", "content", "createdOn");

		Example<Ticket> example = Example.of(ticketWithThisTitleTicket, exampleMatcher);

		return ticketRepository.findAll(example, Sort.by(Direction.ASC, "id"));
	}

	@Override
	public Ticket getTicketById(Long id) {
		return ticketRepository.findById(id).orElseThrow(RuntimeException::new);
	}
}
