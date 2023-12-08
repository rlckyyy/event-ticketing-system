package relucky.code.eventservice.mapper;

import org.mapstruct.Mapper;
import relucky.code.eventservice.dto.EventDTO;
import relucky.code.eventservice.entity.Event;


@Mapper
public interface EventMapper {
    Event toModel(EventDTO eventDTO);
    EventDTO toDTO(Event event);
}
