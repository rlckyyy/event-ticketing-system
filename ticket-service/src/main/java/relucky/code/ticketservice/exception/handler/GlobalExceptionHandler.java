package relucky.code.ticketservice.exception.handler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import relucky.code.ticketservice.exception.TicketNotFoundException;
import relucky.code.ticketservice.exception.TicketReturnDateExpiredException;
import relucky.code.ticketservice.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TicketReturnDateExpiredException.class)
    ProblemDetail handle(TicketReturnDateExpiredException e){
        return toDetails(400,e.getMessage());
    }
    @ExceptionHandler(TicketNotFoundException.class)
    ProblemDetail handle(TicketNotFoundException e){
        return toDetails(404,e.getMessage());
    }
    @ExceptionHandler(UserNotFoundException.class)
    ProblemDetail handle(UserNotFoundException e){
        return toDetails(404,e.getMessage());
    }
    private ProblemDetail toDetails(int code , String detail){
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(code) , detail);
    }
}
