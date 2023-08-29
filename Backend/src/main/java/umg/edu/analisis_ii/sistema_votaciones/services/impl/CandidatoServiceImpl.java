package umg.edu.analisis_ii.sistema_votaciones.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umg.edu.analisis_ii.sistema_votaciones.models.Candidato;
import umg.edu.analisis_ii.sistema_votaciones.projections.CandidatoProjection;
import umg.edu.analisis_ii.sistema_votaciones.repositories.CandidatoRepository;
import umg.edu.analisis_ii.sistema_votaciones.services.CandidatoService;

import java.util.List;
import java.util.Optional;
/**
 * @author mvracot
 * */
@Service
public class CandidatoServiceImpl implements CandidatoService {
    @Autowired
    private CandidatoRepository candidatoRepository;

    @Override
    public List<CandidatoProjection> findAllCanditatos(String tipo_candidato) {
        return candidatoRepository.findAllCanditatos(tipo_candidato);
    }

    @Override
    public List<Candidato> getAllCandidatos() {
        return candidatoRepository.findAll();
    }

    @Override
    public Candidato getCandidatoById(Long id) {
        Optional<Candidato> optionalCandidato = candidatoRepository.findById(id);
        return optionalCandidato.orElse(null);
    }

    @Override
    public List<Candidato> findByTipoCandidato(String tipoCandidato) {
        return candidatoRepository.findByTipoCandidato(tipoCandidato);
    }

    @Override
    public Candidato saveCandidato(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }

    @Override
    public void deleteCandidato(Long id) {
        candidatoRepository.deleteById(id);
    }
}

