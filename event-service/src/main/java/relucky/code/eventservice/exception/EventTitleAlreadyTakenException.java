package relucky.code.eventservice.exception;


public class EventTitleAlreadyTakenException extends RuntimeException{
    public EventTitleAlreadyTakenException(String message) {
        super(message);
    }
}
