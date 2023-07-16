package com.example.form.infraestructure.advice;

import com.example.form.application.exception.PasswordNotMachException;
import com.example.form.infraestructure.exception.UserException;
import feign.FeignException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ProblemDetail> feignException(FeignException error){
        var status=error.status()==401?HttpStatus.UNAUTHORIZED:HttpStatus.NOT_FOUND;
        var detail=error.status()==401?"Expired token":"Not found";
        ProblemDetail problemDetail= ProblemDetail.forStatusAndDetail(status,
                detail);
        problemDetail.setTitle(detail);
        return ResponseEntity.status(error.status()).body(problemDetail);
    }
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ProblemDetail> userException(UserException error){
        ProblemDetail problemDetail= ProblemDetail.forStatusAndDetail(error.getStatus(),
                error.getMessage());
        problemDetail.setTitle(error.getTitle());
        return ResponseEntity.status(error.getStatus()).body(problemDetail);
    }
    @ExceptionHandler(PasswordNotMachException.class)
    public ResponseEntity<ProblemDetail> passwordNotMachException(PasswordNotMachException error){
        ProblemDetail problemDetail= ProblemDetail.forStatusAndDetail(error.getStatus(),
                error.getMessage());
        problemDetail.setTitle(error.getTitle());
        return ResponseEntity.status(error.getStatus()).body(problemDetail);
    }
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException exception) {
        return exception.getBindingResult()
                .getAllErrors()
                .stream()
                .collect(Collectors.toMap(objectError -> ((FieldError) objectError).getField(),
                        DefaultMessageSourceResolvable::getDefaultMessage,
                        (existingValue, newValue) -> existingValue + ", " + newValue));
    }

}
