package umg.edu.analisis_ii.sistema_votaciones.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umg.edu.analisis_ii.sistema_votaciones.exception.ResourceNotFoundException;
import umg.edu.analisis_ii.sistema_votaciones.models.Usuario;
import umg.edu.analisis_ii.sistema_votaciones.repositories.UsuarioRepo;
import umg.edu.analisis_ii.sistema_votaciones.services.UsuarioServicio;

import java.util.Optional;

@Service
public class UsuarioServicempl implements UsuarioServicio {
    @Autowired
    private UsuarioRepo repositorio;


    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return repositorio.save(usuario);
    }

    @Transactional(readOnly = true)
    public Iterable<Usuario> listarUsuarios() {
        return repositorio.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario listarId(Integer id) {
        return repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro el usuario" + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findbyCorreo(String correo) {
        return repositorio.findByCorreo(correo);
    }

    @Override
    public Optional<Usuario> findByCui(String cui) {
        return repositorio.findByCui(cui);
    }

}