package umg.analisis.sistemas.apirenap.services;

import umg.analisis.sistemas.apirenap.commons.CommonSvc;
import umg.analisis.sistemas.apirenap.models.Dpi;
import umg.analisis.sistemas.apirenap.projections.ConsultaCiudadanoProjection;

public interface DpiSvc extends CommonSvc<Dpi> {

    public ConsultaCiudadanoProjection getCiudadanoPorDpi(String dpi, boolean estadoCivil, boolean segundoNombre);

    public Boolean validarEstadoCivil(String dpi);

    public Boolean validarSegundoNombreExist(String dpi);
}
