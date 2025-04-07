package co.edu.uceva.cursoservice.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Curso {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Debe indicar si está activo o no")
    private Boolean activo;

    @Min(value = 0, message = "Los cupos no pueden ser menores a 0")
    private byte cuposDisponibles;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @NotBlank(message = "La duración no puede estar vacía")
    @Pattern(
            regexp = "^(?:(?:[1-9]\\d*)H)?(?:(?:[1-9]\\d*)m)?$",
            message = "La duración debe estar en formato como '2H', '35m' o '2H35m'"
    )
    private String duracion;


    @NotBlank(message = "La fecha de creación no puede estar vacía")
    @Pattern(
            regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$",
            message = "La fecha debe estar en el formato yyyy-MM-dd (ej: 2025-04-07)"
    )
    private String fechaCreacion;


    @NotBlank(message = "El horario no puede estar vacío")
    @Pattern(
            regexp = "^((Lunes|Martes|Miércoles|Jueves|Viernes|Sábado|Domingo)(,\\s?(Lunes|Martes|Miércoles|Jueves|Viernes|Sábado|Domingo))*)\\s([01]\\d|2[0-3]):[0-5]\\d$",
            message = "El horario debe tener el formato: Día(s) HH:mm (ej: Lunes 08:00 o Lunes,Miércoles 14:30)"
    )
    private String horario;


    @NotNull(message = "Debe especificar el ID del docente")
    private Long idDocente;

    @NotNull(message = "Debe especificar el ID del semestre")
    private Long idSemestre;

    @NotBlank(message = "La modalidad no puede estar vacía")
    @Pattern(
            regexp = "^(virtual|presencial|mixto)$",
            message = "La modalidad debe ser: virtual, presencial o mixto"
    )
    private String modalidad;


    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Min(value = 1, message = "Debe tener al menos 1 crédito")
    private byte numeroCreditos;
}
