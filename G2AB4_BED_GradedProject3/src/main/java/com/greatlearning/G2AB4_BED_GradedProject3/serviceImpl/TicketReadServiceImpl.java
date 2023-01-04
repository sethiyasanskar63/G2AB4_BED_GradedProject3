package com.greatlearning.G2AB4_BED_GradedProject3.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.G2AB4_BED_GradedProject3.entity.Ticket;
import com.greatlearning.G2AB4_BED_GradedProject3.repository.TicketRepository;
import com.greatlearning.G2AB4_BED_GradedProject3.service.TicketReadService;

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
		Ticket ticketsWithThisTitleTicket = new Ticket();
		ticketsWithThisTitleTicket.setTitle(title);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("title", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "shortDescription", "content", "createdOn");

		Example<Ticket> example = Example.of(ticketsWithThisTitleTicket, exampleMatcher);

		return ticketRepository.findAll(example, Sort.by(Direction.ASC, "id"));
	}

	@Override
	public Ticket getTicketById(int id) {
		Ticket ticketWithThisIdTicket = new Ticket();
		ticketWithThisIdTicket.setId(id);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("id", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("title", "shortDescription", "content", "createdOn");

		Example<Ticket> example = Example.of(ticketWithThisIdTicket, exampleMatcher);
		List<Ticket> tempList = ticketRepository.findAll(example);

		return tempList.remove(0);
	}
}
