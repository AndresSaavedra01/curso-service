package co.edu.uceva.cursoservice.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private byte cuposDisponibles;
    private String descripcion;
    private int duracion;
    private String fechaCreacion;
    private String horario;
    private Long idDocente;
    private Long idSemestre;
    private String modalidad;
    private String nombre;
    private byte numeroCreditos;
}
