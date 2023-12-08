package relucky.code.ticketservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "event", url = "http://localhost:8801", path = "/api/v1/user")
public interface UserClient {
    @GetMapping("/{id}")
    Object findById(@PathVariable String id);
}
