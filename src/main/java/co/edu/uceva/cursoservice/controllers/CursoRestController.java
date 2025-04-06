package co.edu.uceva.cursoservice.controllers;

import co.edu.uceva.cursoservice.model.entities.Curso;
import co.edu.uceva.cursoservice.model.services.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/curso-service")
public class CursoRestController {

    private ICursoService cursoService;

    @Autowired
    public CursoRestController(ICursoService cursoService) {this.cursoService = cursoService;}

    @GetMapping("/cursos")
    public List<Curso> getCursos() {return cursoService.findAll();}

    @GetMapping("/cursos/page/{page}")
    public Page<Curso> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        return cursoService.findAll(pageable);
    }
    @PostMapping("/cursos")
    public Curso save(@RequestBody Curso curso) {return cursoService.save(curso);}

    @DeleteMapping("/cursos")
    public void delete(@RequestBody Curso curso) {cursoService.delete(curso);}

    @PutMapping("/cursos")
    public Curso update(@RequestBody Curso curso) {return cursoService.update(curso);}

    @GetMapping("/cursos/{id}")
    public Curso findById(@PathVariable("id") Long id) {return cursoService.findById(id);}
}
