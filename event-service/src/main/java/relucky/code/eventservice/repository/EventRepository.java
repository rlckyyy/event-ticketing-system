package relucky.code.eventservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import relucky.code.eventservice.entity.Event;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findByTitle(String title);
}
