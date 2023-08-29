package umg.edu.analisis_ii.sistema_votaciones.projections;

/**
 * @author mvracot
 * */
public interface CandidatoProjection {
        Long getId();
        String getNombre_pres();
        String getNombre_vice();
        String getPartido_politico();
        String getTipo_candidato();
        String getImagen_url();
    }
