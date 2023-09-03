package umg.edu.analisis_ii.sistema_votaciones.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umg.edu.analisis_ii.sistema_votaciones.models.UsuarioVoto;
import umg.edu.analisis_ii.sistema_votaciones.repositories.UsuarioVotoRepository;
import umg.edu.analisis_ii.sistema_votaciones.services.UsuarioVotoService;

import java.util.Optional;

@Service
public class UsuarioVotoServiceImpl implements UsuarioVotoService {
    @Autowired
    private UsuarioVotoRepository usuarioVotoRepository;

    @Override
    public Optional<UsuarioVoto> findbyCui(String cui) {
        return usuarioVotoRepository.findById(cui);
    }

    @Override
    public UsuarioVoto save(UsuarioVoto usuario) {
        return usuarioVotoRepository.save(usuario);
    }
}
