package co.edu.uceva.cursoservice.domain.exception;

import co.edu.uceva.cursoservice.domain.model.Curso;

public class CursoNoEncontradoException extends RuntimeException {
    public CursoNoEncontradoException(Long id) {
        super("El curso con ID " + id + " no existe en la base de datos");
    }
}
