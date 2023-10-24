package umg.edu.analisis_ii.sistema_votaciones.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umg.edu.analisis_ii.sistema_votaciones.client.services.TseConsumeService;
import umg.edu.analisis_ii.sistema_votaciones.dtos.DataTseDto;

@RestController
@RequestMapping("/tse")
@CrossOrigin("*")
public class ControllerTseApiConsumer {

    @Autowired
    private TseConsumeService tseConsumeService;

    @GetMapping("/empadronado/{cui}")
    //@ApiOperation("Encontrar votante empradonado por el CUI")
    public ResponseEntity<DataTseDto> findVotanteByCui(@PathVariable String cui) {
        return ResponseEntity.ok(tseConsumeService.obtenerDataTseDto(cui)) ;
    }
}
