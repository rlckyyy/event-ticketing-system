package relucky.code.ticketservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import relucky.code.ticketservice.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
