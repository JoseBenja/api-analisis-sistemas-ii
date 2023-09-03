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

    @PostMapping("/emitirVotacion")
    public Voto saveVoto(@RequestBody Voto voto) {
        System.out.println(" ," + voto.getCui_votante()+ " ,"+ voto.getPresidente_id()+ " ,"+ voto.getAlcalde_id()+ voto.getDiputado_lista_id());

        return votoService.saveVoto(voto);
    }

    @DeleteMapping("/{id}")
    public void deleteVoto(@PathVariable Long id) {
        votoService.deleteVoto(id);
    }
}

