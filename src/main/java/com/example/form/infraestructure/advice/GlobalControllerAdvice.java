package com.example.form.infraestructure.advice;

import com.example.form.application.exception.PasswordNotMachException;
import com.example.form.domain.exception.LanguageNotFoundException;
import com.example.form.domain.exception.UserAlreadyRegistered;
import com.example.form.domain.exception.UserNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.ConnectException;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerAdvice {
    private final MessageSource messageSource;
    private final Locale locale;

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ProblemDetail> feignException(FeignException error) {
        HttpStatus status = null;
        String title = "";
        String message = "";
        if (error.status() == 401) {
            status = HttpStatus.UNAUTHORIZED;
            title = messageSource.getMessage("error.feign_client.token_expired.title", null, locale);
            message = messageSource.getMessage("error.feign_client.token_expired.message", null, locale);
        } else {
            status = HttpStatus.NOT_FOUND;
            title = messageSource.getMessage("error.feign_client.not_found.title", null, locale);
            message = messageSource.getMessage("error.feign_client.not_found.message", null, locale);
        }

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status,
                message);
        problemDetail.setTitle(title);
        return ResponseEntity.status(error.status()).body(problemDetail);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ProblemDetail> userException(UserNotFoundException exception) {
        String title = messageSource.getMessage("error.user.not_found.title", null, locale);
        String message = messageSource.getMessage("error.user.not_found.message", new Object[]{exception.getEmail()}, locale);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                message);
        problemDetail.setTitle(title);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }
    @ExceptionHandler(UserAlreadyRegistered.class)
    public ResponseEntity<ProblemDetail> userAlreadyRegistered(UserAlreadyRegistered exception) {
        String title = messageSource.getMessage("error.user.already_registered.title", null, locale);
        String message = messageSource.getMessage("error.user.already_registered.message", new Object[]{exception.getId()}, locale);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT,
                message);
        problemDetail.setTitle(title);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(problemDetail);
    }

    @ExceptionHandler(PasswordNotMachException.class)
    public ResponseEntity<ProblemDetail> passwordNotMachException(PasswordNotMachException error) {
        String title = messageSource.getMessage("error.user.password_not_match.title", null, locale);
        String message = messageSource.getMessage("error.user.password_not_match.message", null, locale);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                message);
        problemDetail.setTitle(title);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problemDetail);
    }

    @ExceptionHandler(LanguageNotFoundException.class)
    public ResponseEntity<ProblemDetail> languageException(LanguageNotFoundException exception) {
        String title = messageSource.getMessage("error.language.not_found.title", null, locale);
        String message = messageSource.getMessage("error.language.not_found.message", new Object[]{exception.getLanguageId()}, locale);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                message);
        problemDetail.setTitle(title);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }

    @ExceptionHandler({CannotGetJdbcConnectionException.class, CannotCreateTransactionException.class,
            ConnectException.class, DataAccessResourceFailureException.class})
    public ResponseEntity<ProblemDetail> databaseNotPresent(Exception exception) {
        log.error("Database Not Available");
        String title = messageSource.getMessage("error.data_base.not_available.title", null, locale);
        String message = messageSource.getMessage("error.data_base.not_available.message", null, locale);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.SERVICE_UNAVAILABLE,
                message);
        problemDetail.setTitle(title);
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(problemDetail);
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
