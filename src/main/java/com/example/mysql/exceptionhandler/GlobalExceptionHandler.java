package com.example.mysql.exceptionhandler;

import com.example.mysql.Util.CustomResponse;
import com.example.mysql.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Map> handleError(UserNotFoundException userNotFoundException){
       return CustomResponse.notfound(userNotFoundException.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map> handleDefaultError(Exception exception){
        return CustomResponse.error(exception.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map> handleValidationError(MethodArgumentNotValidException exception){
        return CustomResponse.badRequest(createErrorMessage(exception));
    }

   private String createErrorMessage(MethodArgumentNotValidException exception) {
       return exception.getFieldError().getDefaultMessage()+exception.getFieldError().getRejectedValue();
   }


}
