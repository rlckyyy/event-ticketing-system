package relucky.code.eventservice.dto;


import relucky.code.eventservice.enums.EventType;

import java.time.LocalDate;

public record EventDTO(
        String title,
        LocalDate time,
        EventType eventType,
        String description
) {
}
