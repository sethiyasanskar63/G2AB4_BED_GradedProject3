package com.gl.TicketTrackerApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.TicketTrackerApplication.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM TICKET WHERE TITLE ILIKE %?1% or SHORT_DESCRIPTION ILIKE %?1%")
	List<Ticket> findTicketByTitleOrShortDescription(String searchValue);
}
