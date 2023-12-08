package relucky.code.ticketservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import relucky.code.ticketservice.util.Event;

@FeignClient(name = "event")
public interface EventClient {
    @GetMapping("/{id}")
    Event getById(@PathVariable Long id);
}
