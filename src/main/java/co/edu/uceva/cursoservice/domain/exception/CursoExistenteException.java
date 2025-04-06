package co.edu.uceva.cursoservice.domain.exception;

public class CursoExistenteException extends RuntimeException {
    public CursoExistenteException(String nombre) {
        super("El curso " + nombre + " ya existe en la base de datos");
    }
}
