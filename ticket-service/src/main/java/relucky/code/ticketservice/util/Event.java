package relucky.code.ticketservice.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Event(
        String title,
        LocalDate time,
        String eventType,
        String description
) {
}
