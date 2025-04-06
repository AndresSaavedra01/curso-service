package co.edu.uceva.cursoservice.domain.exception;

public class PaginasSinCursos extends RuntimeException {
    public PaginasSinCursos(int page) {
        super("No hay cursos en la pagina solicitada: " + page);
    }
}
