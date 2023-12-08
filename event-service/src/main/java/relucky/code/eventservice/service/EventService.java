package relucky.code.eventservice.service;



import relucky.code.eventservice.dto.EventDTO;

import java.util.List;

public interface EventService {
    List<EventDTO> getAll();
    EventDTO getOne(Long id);
    EventDTO save(EventDTO eventDTO);
    void delete(Long id);
}
