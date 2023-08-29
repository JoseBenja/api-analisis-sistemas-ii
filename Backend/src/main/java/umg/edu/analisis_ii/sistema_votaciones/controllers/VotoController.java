package umg.edu.analisis_ii.sistema_votaciones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umg.edu.analisis_ii.sistema_votaciones.models.Voto;
import umg.edu.analisis_ii.sistema_votaciones.services.VotoService;

import java.util.List;

@RestController
@RequestMapping("/votos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VotoController {
    @Autowired
    private VotoService votoService;

    @GetMapping
    public List<Voto> getAllVotos() {
        return votoService.getAllVotos();
    }

    @GetMapping("/{id}")
    public Voto getVotoById(@PathVariable Long id) {
        return votoService.getVotoById(id);
    }

    @PostMapping
    public Voto saveVoto(@RequestBody Voto voto) {
        return votoService.saveVoto(voto);
    }

    @DeleteMapping("/{id}")
    public void deleteVoto(@PathVariable Long id) {
        votoService.deleteVoto(id);
    }
}

