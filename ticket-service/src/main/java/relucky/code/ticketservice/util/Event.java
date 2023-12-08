package relucky.code.ticketservice.util;

import java.time.LocalDate;

public record Event(
        String title,
        LocalDate time,
        String eventType,
        String description
) {
}
