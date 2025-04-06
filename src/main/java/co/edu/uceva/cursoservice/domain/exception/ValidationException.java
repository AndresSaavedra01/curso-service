package co.edu.uceva.cursoservice.domain.exception;

import org.springframework.validation.BindingResult;

public class ValidationException extends RuntimeException {
    public final BindingResult result;
    public ValidationException(BindingResult result) {
        super("Error de validación de datos.");
        this.result = result;
    }
}
