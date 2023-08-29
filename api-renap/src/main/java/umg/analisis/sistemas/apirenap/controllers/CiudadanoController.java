package umg.analisis.sistemas.apirenap.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umg.analisis.sistemas.apirenap.commons.CommonController;
import umg.analisis.sistemas.apirenap.models.Ciudadano;
import umg.analisis.sistemas.apirenap.services.CiudadanoSvc;

@Api
@RestController
@RequestMapping("/ciudadano")
public class CiudadanoController extends CommonController<Ciudadano, CiudadanoSvc> {

    @Autowired
    CiudadanoSvc ciudadanoSvc;

    @GetMapping("/probar-servicio")
    public ResponseEntity<String> probarServicio() {
        return ResponseEntity.ok("Hola Mundo!!");
    }


}
