package relucky.code.eventservice.dto;


import java.time.LocalDate;

public record EventDTO(
        String title,
        LocalDate time,
        String description
) {
}
