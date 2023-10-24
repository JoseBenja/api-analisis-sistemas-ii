package umg.edu.analisis_ii.sistema_votaciones.projections;

public interface ConsultaCiudadanoProjection {
        String getCui();
        String getNombreCompleto();
        String getSexo();
        String getNacionalidad();
        String getFechaNacimiento();
        String getDireccionCompleta();
        String getEtnia();
        Boolean getAnalfabeta();
        String getIdioma();
        String getDiscapacidad();
}
