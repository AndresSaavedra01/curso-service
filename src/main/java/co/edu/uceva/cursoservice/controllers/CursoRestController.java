package co.edu.uceva.cursoservice.controllers;

import co.edu.uceva.cursoservice.model.entities.Curso;
import co.edu.uceva.cursoservice.model.services.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/curso-service")
public class CursoRestController {

    private ICursoService cursoService;

    @Autowired
    public CursoRestController(ICursoService cursoService) {this.cursoService = cursoService;}

    @GetMapping("/cursos")
    public List<Curso> getAllCursos() {return cursoService.findAll();}

    @PostMapping("/cursos")
    public Curso saveCurso(@RequestBody Curso curso) {return cursoService.save(curso);}

    @DeleteMapping("/cursos")
    public void deleteCurso(@RequestBody Curso curso) {cursoService.delete(curso);}

    @PutMapping("/productos")
    public Curso updateCurso(@RequestBody Curso curso) {return cursoService.update(curso);}

    @GetMapping("/productos/{id}")
    public Curso findByID(@PathVariable("id") Long id) {return cursoService.findById(id);}
}
