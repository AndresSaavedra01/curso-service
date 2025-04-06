package co.edu.uceva.cursoservice.model.services;

import co.edu.uceva.cursoservice.model.entities.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Interface que define los métodos que se pueden realizar sobre la entidad Producto
 */
public interface ICursoService {
    Curso save(Curso curso);
    void delete(Curso curso);
    Curso findById(Long id);
    Curso update(Curso curso);
    List<Curso> findAll();
    Page<Curso> findAll(Pageable pageable);
}

