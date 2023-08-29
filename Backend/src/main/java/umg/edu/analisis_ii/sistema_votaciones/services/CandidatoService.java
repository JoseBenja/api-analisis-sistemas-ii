package umg.edu.analisis_ii.sistema_votaciones.services;

import umg.edu.analisis_ii.sistema_votaciones.models.Candidato;
import umg.edu.analisis_ii.sistema_votaciones.projections.CandidatoProjection;

import java.util.List;
/**
 * @author mvracot
 * */
public interface CandidatoService {
    List<CandidatoProjection> findAllCanditatos(String tipo_candidato);
    List<Candidato> getAllCandidatos();
    Candidato getCandidatoById(Long id);
    List<Candidato> findByTipoCandidato(String tipoCandidato);
    Candidato saveCandidato(Candidato candidato);
    void deleteCandidato(Long id);
}
