package relucky.code.ticketservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import relucky.code.ticketservice.client.EventClient;
import relucky.code.ticketservice.client.UserClient;
import relucky.code.ticketservice.entity.Ticket;
import relucky.code.ticketservice.exception.TicketNotFoundException;
import relucky.code.ticketservice.exception.TicketReturnDateExpiredException;
import relucky.code.ticketservice.exception.UserNotFoundException;
import relucky.code.ticketservice.repository.TicketRepository;
import relucky.code.ticketservice.service.TicketService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final EventClient eventClient;
    private final UserClient userClient;

    @Override
    public List<Ticket> findUserTickets(String userId) {
        return ticketRepository.findAllByUserId(userId);
    }

    @Override
    public Ticket boughtTicket(String userId, Long eventId) {
        var checkUser = userClient.findById(userId);
        if (checkUser == null) {
            throw new UserNotFoundException("User with id " + userId + " not found");
        }
        var ticket = new Ticket(eventId, userId);
        ticket.setBoughtTime(LocalDateTime.now());
        ticket.setCode(UUID.randomUUID().toString());
        return ticketRepository.save(ticket);
    }

    @Override
    public boolean returnTicket(Long id) {
        var ticket = ticketRepository
                .findById(id).orElseThrow(() ->
                        new TicketNotFoundException("Ticket with id "+ id + " not found"));
        var event = eventClient.getById(ticket.getEventId());
        if (event.time().isAfter(LocalDate.now().minusDays(1))){
            throw new TicketReturnDateExpiredException("Ticket return date expired");
        }
        ticketRepository.deleteById(id);
        return true;
    }
}
