package co.edu.uceva.cursoservice.UsuarioDocente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocenteDTO {

    private long id;
    private String nombreCompleto;
    private String correo;
    private long telefono;
    private String contrasena;
    private Rol rol;
    private Long cedula; // También considera que sea null-safe
    public enum Rol {
        DOCENTE,
        ESTUDIANTE,
        COORDINADOR,
        DECANO,
        ADMINISTRADOR
    }
}
