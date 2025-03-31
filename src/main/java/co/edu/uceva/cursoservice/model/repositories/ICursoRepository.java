package co.edu.uceva.cursoservice.model.repositories;

import co.edu.uceva.cursoservice.model.entities.Curso;
import org.springframework.data.repository.CrudRepository;

public interface ICursoRepository extends CrudRepository<Curso, Long> {
}
