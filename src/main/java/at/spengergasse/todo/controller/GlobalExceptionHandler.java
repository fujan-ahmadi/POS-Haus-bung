package at.spengergasse.todo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler()
    public ResponseEntity<String> handleAllException(Exception ex, WebRequest webRequest){
        if(ex instanceof IllegalArgumentException illegalArgumentException)
            return new ResponseEntity<String>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);

        if(ex instanceof MethodArgumentNotValidException methodArgumentNotValidException)
            return new ResponseEntity<String>(methodArgumentNotValidException.getMessage(), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
