package relucky.code.eventservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import relucky.code.eventservice.entity.Event;

import java.util.Optional;
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findByTitle(String title);
}
