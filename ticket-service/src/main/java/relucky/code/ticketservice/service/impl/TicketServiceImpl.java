package relucky.code.ticketservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import relucky.code.ticketservice.repository.TicketRepository;
import relucky.code.ticketservice.service.TicketService;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
}
