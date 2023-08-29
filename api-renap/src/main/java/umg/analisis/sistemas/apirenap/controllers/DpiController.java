package umg.analisis.sistemas.apirenap.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/buscar-ciudadano/{dpi}")
    public ResponseEntity<ConsultaCiudadanoProjection> getCiudadanoPorDpi(@PathVariable String dpi) {

        boolean estadoCivil = dpiSvc.validarEstadoCivil(dpi);
        boolean segundoNombre = dpiSvc.validarSegundoNombreExist(dpi);

        return ResponseEntity.ok(dpiSvc.getCiudadanoPorDpi(dpi, estadoCivil, segundoNombre));
    }
}
