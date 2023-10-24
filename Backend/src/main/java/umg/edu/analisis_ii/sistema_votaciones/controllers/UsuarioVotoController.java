package umg.edu.analisis_ii.sistema_votaciones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umg.edu.analisis_ii.sistema_votaciones.models.UsuarioVoto;
import umg.edu.analisis_ii.sistema_votaciones.services.UsuarioVotoService;

import java.util.Optional;

/**
 * @author mvracot
 * */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioVotoController {

  /*  @Autowired
    private UsuarioVotoService usuarioVotoService;


    @GetMapping("/busqueda/{cui}")
    public ResponseEntity<Optional<UsuarioVoto>> buscarPorCui(@PathVariable("cui") String cui){
        return ResponseEntity.ok(usuarioVotoService.findbyCui(cui));
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuarioVoto> crearUsuario(@RequestBody UsuarioVoto usuarioVoto){
        return ResponseEntity.ok(usuarioVotoService.save(usuarioVoto));
    }*/

}
