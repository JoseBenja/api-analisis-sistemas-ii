package umg.analisis.sistemas.apirenap.controllers;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umg.analisis.sistemas.apirenap.commons.CommonController;
import umg.analisis.sistemas.apirenap.models.Catalogo;
import umg.analisis.sistemas.apirenap.services.CatalogoSvc;

@Api
@RestController
@RequestMapping("/catalogo")
public class CatalogoController extends CommonController<Catalogo, CatalogoSvc> {
}
