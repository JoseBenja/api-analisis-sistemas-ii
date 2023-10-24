package umg.edu.analisis_ii.sistema_votaciones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umg.edu.analisis_ii.sistema_votaciones.client.services.RenapConsumeService;
import umg.edu.analisis_ii.sistema_votaciones.client.services.TseConsumeService;
import umg.edu.analisis_ii.sistema_votaciones.dtos.DataRenapDto;
import umg.edu.analisis_ii.sistema_votaciones.dtos.DataTseDto;
import umg.edu.analisis_ii.sistema_votaciones.models.Voto;
import umg.edu.analisis_ii.sistema_votaciones.services.VotoService;

import java.util.List;

@RestController
@RequestMapping("/votos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VotoController {
    @Autowired
    private VotoService votoService;

    @Autowired
    private TseConsumeService tseConsumeService;

    @Autowired
    private RenapConsumeService renapConsumeService;

    @GetMapping
    public List<Voto> getAllVotos() {
        return votoService.getAllVotos();
    }

    @GetMapping("/{id}")
    public Voto getVotoById(@PathVariable Long id) {
        return votoService.getVotoById(id);
    }

    @GetMapping("/verificar-info-usuario")
    public ResponseEntity<Boolean> validateUser(@RequestParam("cui") String cui){
        /*DataRenapDto renap = renapConsumeService.obtenerDataRenap(cui);
        DataTseDto tse = tseConsumeService.obtenerDataTseDto(cui);

        if(renap!=null && tse!=null){
            if(renap.getCui().equals(cui) && tse.getCui().equals(cui)){
                return ResponseEntity.ok(true);
            }
        }
        return (ResponseEntity<Boolean>) ResponseEntity.noContent();*/
        DataRenapDto renap = renapConsumeService.obtenerDataRenap(cui);
        DataTseDto tse = tseConsumeService.obtenerDataTseDto(cui);

        boolean isUserValid = renap != null && tse != null && renap.getCui().equals(cui) && tse.getCui().equals(cui);

        return ResponseEntity.ok(isUserValid);
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

