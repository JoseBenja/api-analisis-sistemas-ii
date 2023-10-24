package umg.edu.analisis_ii.sistema_votaciones.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umg.edu.analisis_ii.sistema_votaciones.client.services.RenapConsumeService;
import umg.edu.analisis_ii.sistema_votaciones.client.services.TseConsumeService;
import umg.edu.analisis_ii.sistema_votaciones.dtos.DataRenapDto;
import umg.edu.analisis_ii.sistema_votaciones.dtos.DataTseDto;
import umg.edu.analisis_ii.sistema_votaciones.projections.ConsultaCiudadanoProjection;

@RestController
@RequestMapping("/renap")
@CrossOrigin("*")
public class RenapApiConsumeController {
    @Autowired
    private RenapConsumeService renapConsumeService;

    @GetMapping("/empadronado/{cui}")
    //@ApiOperation("Encontrar votante empradonado por el CUI")
    public ResponseEntity<DataRenapDto> findVotanteByCui(@PathVariable String cui) {
        return ResponseEntity.ok(renapConsumeService.obtenerDataRenap(cui)) ;
    }
}
