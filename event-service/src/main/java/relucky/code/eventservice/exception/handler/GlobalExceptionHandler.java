package relucky.code.eventservice.exception.handler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import relucky.code.eventservice.exception.EventNotFoundException;
import relucky.code.eventservice.exception.TitleAlreadyTakenException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TitleAlreadyTakenException.class)
    ProblemDetail handle(TitleAlreadyTakenException e){
        return toDetails(400,e.getMessage());
    }
    @ExceptionHandler(EventNotFoundException.class)
    ProblemDetail handle(EventNotFoundException e){
        return toDetails(404,e.getMessage());
    }
    private ProblemDetail toDetails(int code , String detail){
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(code) , detail);
    }
}
