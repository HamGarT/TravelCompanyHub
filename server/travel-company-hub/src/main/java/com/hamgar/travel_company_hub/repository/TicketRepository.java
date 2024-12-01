package com.hamgar.travel_company_hub.repository;

import com.hamgar.travel_company_hub.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
