package relucky.code.ticketservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import relucky.code.ticketservice.util.Event;

/**
 * This interface represents a client for accessing event resources.
 */
@FeignClient(name = "event", url = "http://localhost:8802", path = "/api/v1/event")
public interface EventClient {
    @GetMapping("/{id}")
    Event getById(@PathVariable Long id);
}
