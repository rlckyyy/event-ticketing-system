package relucky.code.ticketservice.exception;

public class TicketReturnDateExpiredException extends RuntimeException{
    public TicketReturnDateExpiredException(String message) {
        super(message);
    }
}
