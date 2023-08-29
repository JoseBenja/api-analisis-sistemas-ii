package umg.analisis.sistemas.apirenap.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umg.analisis.sistemas.apirenap.commons.CommonSvcImpl;
import umg.analisis.sistemas.apirenap.models.Dpi;
import umg.analisis.sistemas.apirenap.projections.ConsultaCiudadanoProjection;
import umg.analisis.sistemas.apirenap.repositories.DpiRepository;
import umg.analisis.sistemas.apirenap.services.DpiSvc;

@Service
public class DpiSvcImpl extends CommonSvcImpl<Dpi, DpiRepository> implements DpiSvc {

    @Autowired
    DpiRepository dpiRepository;

    @Override
    public ConsultaCiudadanoProjection getCiudadanoPorDpi(String dpi, boolean estadoCivil, boolean segundoNombre) {

        if (estadoCivil) {
            if (!segundoNombre) {
                try {
                    return dpiRepository.getDatosCasadaConSegundoNombre(dpi);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    return dpiRepository.getDatosCasadaSinSegundoNombre(dpi);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            if (!segundoNombre) {
                try {
                    return dpiRepository.getDatosSolteroConSegundoNombre(dpi);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    return dpiRepository.getDatosSolteroSinSegundoNombre(dpi);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public Boolean validarEstadoCivil(String dpi) {
        try {
            return dpiRepository.validarEstadoCivil(dpi);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean validarSegundoNombreExist(String dpi) {
        try {
            return dpiRepository.validarSegundoApellidoExist(dpi);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
