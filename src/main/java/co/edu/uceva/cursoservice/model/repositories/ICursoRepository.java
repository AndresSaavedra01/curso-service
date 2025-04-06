package co.edu.uceva.cursoservice.model.repositories;

import co.edu.uceva.cursoservice.model.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Curso, Long> {
}
