package co.edu.uceva.cursoservice.UsuarioDocente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name = "usuario-service")
public interface DocenteClient {
    @GetMapping("/api/v1/usuario-service/usuarios/docentes")
    Map<String, List<DocenteDTO>> obtenerDocentes();
}
