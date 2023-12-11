package relucky.code.eventservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ticket")
public interface TicketClient {
    @DeleteMapping("event/{eventId}")
    void deleteByEventId(@PathVariable Long eventId);
}
