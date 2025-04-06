package co.edu.uceva.cursoservice.domain.exception;

public class NoHayCursosException extends RuntimeException {
    public NoHayCursosException() {
        super("No se encontraron facultades en la base de datos");    }
}
