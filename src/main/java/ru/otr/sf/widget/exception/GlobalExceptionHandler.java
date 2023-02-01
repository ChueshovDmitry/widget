package ru.otr.sf.widget.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> UsernameNotFoundExceptionHandling(EntityNotFoundException exception,WebRequest request){
        ErrorDetails errorDetails =
                new ErrorDetails(new Date()
                        ,exception.getMessage()+ " сущность не найдена"
                        ,request.getDescription(false)
                        ,    NOT_FOUND
                        ,    NOT_FOUND.value());
        return new ResponseEntity<>(errorDetails,NOT_FOUND);
    }
}

