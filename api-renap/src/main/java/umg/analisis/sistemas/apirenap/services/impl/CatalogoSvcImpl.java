package umg.analisis.sistemas.apirenap.services.impl;

import org.springframework.stereotype.Service;
import umg.analisis.sistemas.apirenap.commons.CommonSvcImpl;
import umg.analisis.sistemas.apirenap.models.Catalogo;
import umg.analisis.sistemas.apirenap.repositories.CatalogoRepository;
import umg.analisis.sistemas.apirenap.services.CatalogoSvc;

@Service
public class CatalogoSvcImpl extends CommonSvcImpl<Catalogo, CatalogoRepository> implements CatalogoSvc {
}
