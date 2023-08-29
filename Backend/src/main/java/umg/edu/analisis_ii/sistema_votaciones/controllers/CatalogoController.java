package umg.edu.analisis_ii.sistema_votaciones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umg.edu.analisis_ii.sistema_votaciones.models.Catalogo;
import umg.edu.analisis_ii.sistema_votaciones.models.TipoCatalogo;
import umg.edu.analisis_ii.sistema_votaciones.repositories.CatalogoRepository;
import umg.edu.analisis_ii.sistema_votaciones.services.CatalogoService;
import umg.edu.analisis_ii.sistema_votaciones.services.impl.TipoCatalogoService;

import java.util.List;

@RestController
@RequestMapping("/catalogos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CatalogoController {
    @Autowired
    private CatalogoService catalogoService;

    @Autowired
    private CatalogoRepository catalogoRepository;

    @Autowired
    private TipoCatalogoService tipoCatalogoService;

    @GetMapping
    public List<Catalogo> getAllCatalogos() {
        return catalogoService.getAllCatalogos();
    }

    @GetMapping("/por-tipo/{tipo}")
    public List<Catalogo> getCatalogosByTipo(@PathVariable String tipo) {
        return catalogoRepository.findByTipoCatalogo(tipo);
    }

    @GetMapping("/{nombre}")
    public Catalogo getCatalogoByNombre(@PathVariable String nombre) {
        return catalogoService.getCatalogoByNombre(nombre);
    }

    @PostMapping("/crearTipoCatalogo")
    public ResponseEntity<TipoCatalogo> saveTipoCatalogo(@RequestBody TipoCatalogo tipoCatalogo) {
        TipoCatalogo obj = tipoCatalogoService.saveTipoCatalogo(tipoCatalogo);
        if(obj == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(obj);
    }

    @PostMapping("crearCatalogo")
    public Catalogo saveCatalogo(@RequestBody Catalogo catalogo) {
        return catalogoService.saveCatalogo(catalogo);
    }



    @DeleteMapping("/{nombre}")
    public void deleteCatalogo(@PathVariable String nombre) {
        catalogoService.deleteCatalogo(nombre);
    }
}

