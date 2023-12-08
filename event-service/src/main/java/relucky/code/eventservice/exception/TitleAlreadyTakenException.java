package relucky.code.eventservice.exception;


public class TitleAlreadyTakenException extends RuntimeException{
    public TitleAlreadyTakenException(String message) {
        super(message);
    }
}
