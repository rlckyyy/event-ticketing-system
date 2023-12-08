package relucky.code.ticketservice.service;

import relucky.code.ticketservice.entity.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> findUserTickets(String userId);
    Ticket boughtTicket(String userId , Long eventId);
    boolean returnTicket(Long id);
}
