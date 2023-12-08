package relucky.code.ticketservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import relucky.code.ticketservice.service.TicketService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/ticket")
public class TicketController {
    private final TicketService ticketService;
}
