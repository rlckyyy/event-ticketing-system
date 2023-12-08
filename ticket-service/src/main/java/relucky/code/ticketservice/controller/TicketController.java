package relucky.code.ticketservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import relucky.code.ticketservice.service.TicketService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;
    @GetMapping("{id}")
    ResponseEntity<?> find(
            @PathVariable String id
    ){
        return ResponseEntity
                .ok(ticketService.findUserTickets(id));
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> delete(
            @PathVariable Long id
    ){
        return ResponseEntity
                .ok(ticketService.returnTicket(id));
    }
    @PostMapping
    ResponseEntity<?> boughtTicket(
            @RequestParam String userId,
            @RequestParam Long eventId
    ){
        return ResponseEntity.status(201)
                .body(ticketService.boughtTicket(userId, eventId));
    }
}
