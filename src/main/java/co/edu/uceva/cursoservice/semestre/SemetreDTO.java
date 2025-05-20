package co.edu.uceva.cursoservice.semestre;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SemetreDTO {

    private long id;
    private long idPrograma;
    private Byte numeroSemestre;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaInicio;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaFin;

    private boolean activo;

    @Override
    public String toString() {
        return "SemetreDTO{" +
                "id=" + id +
                ", idPrograma=" + idPrograma +
                ", numeroSemestre=" + numeroSemestre +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", activo=" + activo +
                '}';
    }
}
