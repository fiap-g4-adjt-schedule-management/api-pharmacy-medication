package br.com.fiap_tc5.hackaton.infrastructure.exception;

import br.com.fiap_tc5.hackaton.infrastructure.dtos.ErrorResponseDTO;
import br.com.fiap_tc5.hackaton.infrastructure.exception.factory.ExceptionDetailsFactory;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return ExceptionDetailsFactory.createProblem(
                ex.getClass().toString(),
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                request
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDTO handleGenericException(Exception e, WebRequest request) {
        return ExceptionDetailsFactory.createProblem(e.getClass().toString(), HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected error occurred.", request);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleConstraintViolationException(ConstraintViolationException ex, WebRequest request){
        String message = extractConstraintViolationException(ex);

        return ExceptionDetailsFactory.createProblem(
                ex.getClass().toString(),
                HttpStatus.BAD_REQUEST,
                message,
                request
        );
    }

    private String extractConstraintViolationException(ConstraintViolationException ex) {
        String message = ex.getConstraintViolations()
                .stream()
                .map(violation -> {
                    String field = violation.getPropertyPath().toString();

                    if (field.contains(".")) {
                        field = field.substring(field.lastIndexOf('.') + 1);
                    }

                    return String.format(
                            "Please provide a value for parameter '%s'",
                            field
                    );
                })
                .collect(Collectors.joining(", "));

        return message;
    }
}
