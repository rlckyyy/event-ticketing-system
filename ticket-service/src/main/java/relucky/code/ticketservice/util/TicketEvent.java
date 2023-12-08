package relucky.code.ticketservice.util;

public record TicketEvent(
        String code,
        String status,
        String userId
) {
}
