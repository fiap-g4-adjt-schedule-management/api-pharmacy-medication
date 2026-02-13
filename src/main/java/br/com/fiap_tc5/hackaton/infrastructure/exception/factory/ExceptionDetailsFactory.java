package br.com.fiap_tc5.hackaton.infrastructure.exception.factory;

import br.com.fiap_tc5.hackaton.infrastructure.dtos.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

public class ExceptionDetailsFactory {

    private ExceptionDetailsFactory() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static ErrorResponseDTO createProblem(String type, HttpStatus status, String detail, WebRequest request) {
        return new ErrorResponseDTO(
                type,
                status.getReasonPhrase(),
                status.value(),
                detail,
                request.getDescription(false).replace("uri=", "")
        );
    }
}
