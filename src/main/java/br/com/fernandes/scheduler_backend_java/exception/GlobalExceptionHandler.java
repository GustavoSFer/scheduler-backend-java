package br.com.fernandes.scheduler_backend_java.exception;

import br.com.fernandes.scheduler_backend_java.exception.pessoa.PessoaNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Captura erros de validação do corpo (@RequestBody)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<ApiError> error = new ArrayList<>();

        for (FieldError e : ex.getBindingResult().getFieldErrors()) {
            error.add(
                new ApiError(
                    HttpStatus.BAD_REQUEST.value(),
                    e.getDefaultMessage()
                )
            );

        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(error));
    }

    // (Opcional) Captura erros de validação de parâmetros de URL ou query params
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolation(ConstraintViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(PessoaNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePessoaNotFoundException(PessoaNotFoundException ex) {
        List<ApiError> error = new ArrayList<>();
        error.add(
            new ApiError(
                HttpStatus.NOT_FOUND.value(),
                ex.getMensagem()
            )
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(error));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleMessageNotReadableException(HttpMessageNotReadableException ex) {
        List<ApiError> error = new ArrayList<>();

        error.add(
                new ApiError(
                        HttpStatus.BAD_REQUEST.value(),
                        "Valor inválido. Opções aceitas: PAGO, CANCELADO, ESTORNADO, PENDENTE."
                )
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(error));
    }
}
