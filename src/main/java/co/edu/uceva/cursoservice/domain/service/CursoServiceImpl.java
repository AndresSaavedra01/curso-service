package co.edu.uceva.cursoservice.domain.service;

import co.edu.uceva.cursoservice.domain.model.Curso;
import co.edu.uceva.cursoservice.domain.repository.ICursoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements ICursoService{

    ICursoRepository cursoRepository;

    public CursoServiceImpl(ICursoRepository cursoRepository) {this.cursoRepository = cursoRepository;}

    @Override
    @Transactional
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    @Transactional
    public Curso update(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAll() {
        return (List<Curso>) cursoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Curso> findAll(Pageable pageable) {
        return  cursoRepository.findAll(pageable);
    }

}
