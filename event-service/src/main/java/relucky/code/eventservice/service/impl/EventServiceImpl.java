package relucky.code.eventservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import relucky.code.eventservice.dto.EventDTO;
import relucky.code.eventservice.entity.Event;
import relucky.code.eventservice.exception.EventTitleAlreadyTakenException;
import relucky.code.eventservice.exception.NotFoundException;
import relucky.code.eventservice.mapper.EventMapper;
import relucky.code.eventservice.repository.EventRepository;
import relucky.code.eventservice.service.EventService;


import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for handling Events.
 * This class provides CRUD operations for Events.
 * @author relucky
 */
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public List<EventDTO> getAll() {
        return eventRepository.findAll().stream().map(eventMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public EventDTO getOne(Long id) {
        return eventMapper.toDTO(eventRepository.findById(id).orElseThrow(()-> new NotFoundException("Event with id " + id + " not found")));
    }

    @Override
    public EventDTO save(EventDTO eventDTO) {
        if (eventRepository.findByTitle(eventDTO.title()).isPresent()){
            throw new EventTitleAlreadyTakenException("Title " + eventDTO.title() + " already exist");
        }
        Event event = eventMapper.toModel(eventDTO);
        eventRepository.save(event);
        return eventDTO;
    }

    @Override
    public void delete(Long id) {
        if (eventRepository.findById(id).isEmpty()){
            throw new NotFoundException("Event with id " + id + " not found");
        }
        eventRepository.deleteById(id);
    }
}
