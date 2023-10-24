package umg.analisis.sistemas.apirenap.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umg.analisis.sistemas.apirenap.commons.CommonController;
import umg.analisis.sistemas.apirenap.models.Dpi;
import umg.analisis.sistemas.apirenap.projections.ConsultaCiudadanoProjection;
import umg.analisis.sistemas.apirenap.services.DpiSvc;

@Api
@RestController
@RequestMapping("/dpi")
public class DpiController extends CommonController<Dpi, DpiSvc> {

    @Autowired
    DpiSvc dpiSvc;

    @GetMapping("/buscar-ciudadano")
    public ResponseEntity<ConsultaCiudadanoProjection> getCiudadanoPorDpi(@RequestParam String cui) {

        boolean estadoCivil = dpiSvc.validarEstadoCivil(cui);
        boolean segundoNombre = dpiSvc.validarSegundoNombreExist(cui);

        return ResponseEntity.ok(dpiSvc.getCiudadanoPorDpi(cui, estadoCivil, segundoNombre));
    }
}
