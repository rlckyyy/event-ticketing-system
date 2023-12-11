package relucky.code.ticketservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import relucky.code.ticketservice.entity.Ticket;
import relucky.code.ticketservice.util.Event;

import java.util.Optional;

@FeignClient(name = "event")
public interface EventClient {
    @GetMapping("/{id}")
    Event getById(@PathVariable Long id);
}
