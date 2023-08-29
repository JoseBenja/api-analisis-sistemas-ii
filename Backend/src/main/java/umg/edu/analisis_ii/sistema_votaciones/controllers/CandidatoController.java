package umg.edu.analisis_ii.sistema_votaciones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umg.edu.analisis_ii.sistema_votaciones.models.Candidato;
import umg.edu.analisis_ii.sistema_votaciones.projections.CandidatoProjection;
import umg.edu.analisis_ii.sistema_votaciones.services.CandidatoService;

import java.util.List;
/**
 * @author mvracot
 * */
@RestController
@RequestMapping("/candidatos")
@CrossOrigin("*")
public class CandidatoController {
    @Autowired
    private CandidatoService candidatoService;

    @GetMapping("/por-tipo/{tipo_candidato}")
    public List<CandidatoProjection> getAllCandidatos(@PathVariable String tipo_candidato) {
        return candidatoService.findAllCanditatos(tipo_candidato);
    }

   /* @GetMapping("/por-tipo/{tipo}")
    public List<Candidato> getCandidatosByTipo(@PathVariable String tipo) {
        return candidatoService.findByTipoCandidato(tipo);
    }*/

    @GetMapping("/{id}")
    public Candidato getCandidatoById(@PathVariable Long id) {
        return candidatoService.getCandidatoById(id);
    }

    @PostMapping
    public Candidato saveCandidato(@RequestBody Candidato candidato) {
        return candidatoService.saveCandidato(candidato);
    }

    @DeleteMapping("/{id}")
    public void deleteCandidato(@PathVariable Long id) {
        candidatoService.deleteCandidato(id);
    }
}
