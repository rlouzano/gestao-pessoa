package br.com.gestao.pessoa.exception.handler;

import br.com.gestao.pessoa.exception.Response400Exception;
import br.com.gestao.pessoa.exception.Response403Exception;
import br.com.gestao.pessoa.exception.Response404Exception;
import br.com.gestao.pessoa.exception.handler.domain.ErrorResponse;
import br.com.gestao.pessoa.exception.handler.mapper.ErrorResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class DefaultControllerAdviceHandler {
    private final ErrorResponseMapper mapper = new ErrorResponseMapper();
    @ResponseBody
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> handleError(final Exception ex) {
        if (ex instanceof Response404Exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    mapper.getErrorResponse(((Response404Exception) ex).getStatusText()));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapper.getErrorResponse("Invalid Request."));
    }

    @ResponseBody
    @ExceptionHandler({Response403Exception.class})
    public ResponseEntity<ErrorResponse> Response403Exception(final Response403Exception ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(mapper.getErrorResponse(ex.getStatusText()));
    }

    @ResponseBody
    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<ErrorResponse> Response400Exception(final Response400Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mapper.getErrorResponse("Invalid Request."));
    }

}
