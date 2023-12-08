package relucky.code.userservice.exception.handler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import relucky.code.userservice.exception.EmailRegisteredYetException;
import relucky.code.userservice.exception.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailRegisteredYetException.class)
    ProblemDetail handle(EmailRegisteredYetException e){
        return toDetails(400,e.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    ProblemDetail handle(EntityNotFoundException e){
        return toDetails(404,e.getMessage());
    }

    private ProblemDetail toDetails(int code , String detail){
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(code) , detail);
    }
}
