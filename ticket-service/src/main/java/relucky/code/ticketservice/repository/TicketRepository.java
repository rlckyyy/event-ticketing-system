package relucky.code.ticketservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import relucky.code.ticketservice.entity.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByUserId(String userId);
}
