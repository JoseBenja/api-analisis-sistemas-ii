package umg.edu.analisis_ii.sistema_votaciones.services;


import umg.edu.analisis_ii.sistema_votaciones.models.Voto;

import java.util.List;
/**
 * @author mvracot
 * */
public interface VotoService {
    List<Voto> getAllVotos();
    Voto getVotoById(Long id);
    Voto saveVoto(Voto voto);
    void deleteVoto(Long id);
}

