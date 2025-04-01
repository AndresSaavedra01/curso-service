package co.edu.uceva.cursoservice.model.services;

import co.edu.uceva.cursoservice.model.entities.Curso;

import java.util.List;

public interface ICursoService {
    Curso save(Curso curso);
    void delete(Curso curso);
    Curso findById(Long id);
    Curso update(Curso curso);
    List<Curso> findAll();
}

