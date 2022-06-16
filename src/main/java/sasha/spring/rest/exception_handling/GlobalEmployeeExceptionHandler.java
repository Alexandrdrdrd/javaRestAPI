package sasha.spring.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalEmployeeExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<IncorrectEmployeeData> handleException(NoSuchEmployeeException exception){
        IncorrectEmployeeData data = new IncorrectEmployeeData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectEmployeeData> handleException(Exception exception){
        IncorrectEmployeeData data = new IncorrectEmployeeData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
