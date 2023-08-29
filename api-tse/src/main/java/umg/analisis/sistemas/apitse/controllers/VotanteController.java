package umg.analisis.sistemas.apitse.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umg.analisis.sistemas.sistemavotaciones.commons.CommonController;
import umg.analisis.sistemas.sistemavotaciones.dtos.VotanteDto;
import umg.analisis.sistemas.sistemavotaciones.models.Votante;
import umg.analisis.sistemas.sistemavotaciones.projections.CaracteristicasVotanteProjection;
import umg.analisis.sistemas.sistemavotaciones.services.VotanteSvc;

@Api
@RestController
@RequestMapping("/prueba")
public class VotanteController extends CommonController<Votante, VotanteSvc> {

    @Autowired
    VotanteSvc votanteSvc;

    @GetMapping("/probar-servicio")
    public ResponseEntity<String> probarServicio() {
        return ResponseEntity.ok("Hola Mundo!!");
    }

    @PostMapping("/obtener-caracteristicas-votante")
    public ResponseEntity<CaracteristicasVotanteProjection> getCaracteristicasVotante(@RequestBody VotanteDto votanteDto) {
        return ResponseEntity.ok(votanteSvc.getCaracteristicasVotante(votanteDto));
    }

}
