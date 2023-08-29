package umg.edu.analisis_ii.sistema_votaciones.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umg.edu.analisis_ii.sistema_votaciones.models.Voto;
import umg.edu.analisis_ii.sistema_votaciones.repositories.VotoRepository;
import umg.edu.analisis_ii.sistema_votaciones.services.VotoService;

import java.util.List;
import java.util.Optional;
/**
 * @author mvracot
 * */
@Service
public class VotoServiceImpl implements VotoService {
    @Autowired
    private VotoRepository votoRepository;

    @Override
    public List<Voto> getAllVotos() {
        return votoRepository.findAll();
    }

    @Override
    public Voto getVotoById(Long id) {
        Optional<Voto> optionalVoto = votoRepository.findById(id);
        return optionalVoto.orElse(null);
    }

    @Override
    public Voto saveVoto(Voto voto) {
        return votoRepository.save(voto);
    }

    @Override
    public void deleteVoto(Long id) {
        votoRepository.deleteById(id);
    }
}

