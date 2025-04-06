package co.edu.uceva.cursoservice.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Curso {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean activo;
    @NotEmpty(message = "No puede estar vacío")
    private byte cuposDisponibles;
    @NotEmpty(message = "No puede estar vacío")
    private String descripcion;
    @NotEmpty(message = "No puede estar vacío")
    private int duracion;
    @NotEmpty(message = "No puede estar vacío")
    private String fechaCreacion;
    @NotEmpty(message = "No puede estar vacío")
    private String horario;
    @NotEmpty(message = "No puede estar vacío")
    private Long idDocente;
    @NotEmpty(message = "No puede estar vacío")
    private Long idSemestre;
    @NotEmpty(message = "No puede estar vacío")
    private String modalidad;
    @NotEmpty(message = "No puede estar vacío")
    private String nombre;
    @NotEmpty(message = "No puede estar vacío")
    private byte numeroCreditos;
    @NotEmpty(message = "No puede estar vacío")
}
