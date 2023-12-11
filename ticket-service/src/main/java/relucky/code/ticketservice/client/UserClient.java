package relucky.code.ticketservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "user")
public interface UserClient {
    @GetMapping("/{id}")
    Optional<Object> findById(@PathVariable String id);
}
