package com.greatlearning.G2AB4_BED_GradedProject3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.G2AB4_BED_GradedProject3.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
