package relucky.code.userservice.exception;

public class EmailRegisteredYetException extends RuntimeException{
    public EmailRegisteredYetException(String message) {
        super(message);
    }
}
