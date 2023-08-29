package umg.analisis.sistemas.apitse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umg.analisis.sistemas.apitse.commons.CommonController;
import umg.analisis.sistemas.apitse.models.Votante;
import umg.analisis.sistemas.apitse.projections.DatosVotante;
import umg.analisis.sistemas.apitse.services.VotanteSvc;

@Api
@RestController
@RequestMapping("/votante")
public class VotanteController extends CommonController<Votante, VotanteSvc> {

    @GetMapping("/empadronado/{cui}")
    @ApiOperation("Encontrar votante empradonado por el CUI")
    public ResponseEntity<DatosVotante> findVotanteByCui(@PathVariable String cui) {
        return ResponseEntity.ok(this.service.findVotanteByCui(cui));
    }
}
