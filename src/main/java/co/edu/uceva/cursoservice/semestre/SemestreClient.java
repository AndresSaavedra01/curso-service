package co.edu.uceva.cursoservice.semestre;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name = "semestre-service")
public interface SemestreClient {
    @GetMapping("/api/v1/semestre-service/semestres")
    Map<String, List<SemetreDTO>> obtenerSemestre();

}
