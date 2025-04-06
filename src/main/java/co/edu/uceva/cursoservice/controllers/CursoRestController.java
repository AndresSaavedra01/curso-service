package co.edu.uceva.cursoservice.controllers;

import co.edu.uceva.cursoservice.model.entities.Curso;
import co.edu.uceva.cursoservice.model.services.ICursoService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/curso-service")
public class CursoRestController {

    private final ICursoService cursoService;

    private static final String ERROR = "error";
    private static final String MENSAJE = "mensaje";
    private static final String CURSO = "facultad";
    private static final String CURSOS = "facultades";


    public CursoRestController(ICursoService cursoService) {
        this.cursoService = cursoService;
    }

    /**
     LISTAR TODOS LOS CURSOS
     */
    @GetMapping("/cursos")
    public ResponseEntity<Map<String, Object>> getFacultades() {
        Map<String, Object> response = new HashMap<>();

        try{
            List<Curso> facultades = cursoService.findAll();

            if (facultades.isEmpty()){
                response.put(MENSAJE, "El curso no existe");
                response.put(CURSOS, facultades); // para que sea siempre el mismo campo
                return ResponseEntity.status(HttpStatus.OK).body(response); //200 pero lista vacia
            }
            response.put(CURSOS, facultades);
            return ResponseEntity.ok(response);
        }catch (DataAccessException d){
            response.put(MENSAJE, "Error al consultar la base de datos");
            response.put(ERROR, d.getMessage().concat(": ").concat(d.getMostSpecificCause().getMessage()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    /**
     * LISTAR CON PAGINACIÓN
     * */
    @GetMapping("/cursos/page/{page}")
    public ResponseEntity<Object> index(@PathVariable Integer page) {
        Map<String, java.lang.Object> response = new HashMap<>();
        Pageable pageable = PageRequest.of(page, 4);

        try{
            Page<Curso> facultades = cursoService.findAll(pageable);

            if (facultades.isEmpty()){
                response.put(MENSAJE, "No hay cursos en la pagina solicitada.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            return ResponseEntity.ok(facultades);
        } catch (DataAccessException d) {
            response.put(MENSAJE, "Error al consultar la base de datos");
            response.put(ERROR, d.getMessage().concat(": ").concat(d.getMostSpecificCause().getMessage()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }catch (IllegalArgumentException i){
            response.put(MENSAJE, "Numero de pagina inválido.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    /**
     * CREAR UN NUEVO CURSO PASANDO EL OBJETO EN EL CUERPO DE LA PETICIÓN
     **/
    @PostMapping("/cursos")
    public ResponseEntity<Map<String, Object>> save(@RequestBody Curso facultad, BindingResult result) {
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err ->"El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .toList();
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try{
            //Guardar la facultad en la base de datos
            Curso nuevoCurso = cursoService.save(facultad);

            response.put(MENSAJE, "El curso se ha guardado correctamente");
            response.put(CURSO, nuevoCurso);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (DataAccessException d){
            response.put(MENSAJE, "Error al guardar el curso en la base de datos.");
            response.put(ERROR, d.getMessage().concat(": ").concat(d.getMostSpecificCause().getMessage()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    /**
     * EMIMINAR UN CURSO PASANDO EL OBJETO EN EL CUERPO DE LA PETICIÓN
     **/
    @DeleteMapping("/cursos")
    public ResponseEntity<Map<String, Object>> delete(@RequestBody Curso curso) {
        Map<String, Object> response = new HashMap<>();

        try {
            Curso facultadExistente = cursoService.findById(curso.getId());
            if (facultadExistente == null){
                response.put(MENSAJE, "El curso con ID " + curso.getId() + " no existe en la base de datos.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            cursoService.delete(curso);
            response.put(MENSAJE, "El curso se ha eliminado correctamente");
            return ResponseEntity.ok(response);
        }catch (DataAccessException d){
            response.put(MENSAJE, "Error al eliminar el curso en la base de datos.");
            response.put(ERROR, d.getMessage().concat(": ").concat(d.getMostSpecificCause().getMessage()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    /**
     * Actualizar un curso pasando el objeto en el cuerpo de la petición.
     * @param curso: Objeto Curso que se va a actualizar
     */
    @PutMapping("/cursos")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Curso curso, BindingResult result) {
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err ->"El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .toList();
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try{
            //Verificar si existe
            if (cursoService.findById(curso.getId()) == null){
                response.put(MENSAJE, "ERROR: No se pudo editar, el curso con ID: "+ curso.getId()+" no existe en la base de datos.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            //Guardar directamente la facultad actualizada en la base de datos
            Curso facultadActualizada = cursoService.update(curso);

            response.put(MENSAJE, "El curso se ha actualizado correctamente");
            response.put(CURSO, facultadActualizada);
            return ResponseEntity.ok(response);
        }catch (DataAccessException d){
            response.put(MENSAJE,"Error al actualizar el curso en la base de datos.");
            response.put(ERROR, d.getMessage().concat(": ").concat(d.getMostSpecificCause().getMessage()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    /**
     * OBTENER EL CURSO POR SU ID
     **/
    @GetMapping("/cursos/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();

        try{
            Curso facultad = cursoService.findById(id);

            if (facultad == null){
                response.put(MENSAJE,"El curso con ID: " + id + " no existe en la base de datos.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            response.put(MENSAJE, "El curso ha sido cargado correctamente");
            response.put(CURSO, facultad);
            return ResponseEntity.ok(response);
        }catch (DataAccessException d){
            response.put(MENSAJE, "Error al consultar el curso en la base de datos.");
            response.put(ERROR, d.getMessage().concat(": ").concat(d.getMostSpecificCause().getMessage()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }}
