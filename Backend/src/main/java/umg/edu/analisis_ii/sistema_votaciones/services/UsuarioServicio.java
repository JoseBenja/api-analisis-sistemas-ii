package umg.edu.analisis_ii.sistema_votaciones.services;


import umg.edu.analisis_ii.sistema_votaciones.models.Usuario;

import java.util.Optional;

public interface UsuarioServicio {

    public Usuario save(Usuario usuario);

    public Iterable<Usuario> listarUsuarios();

    public Usuario listarId(Integer id);

    public Optional<Usuario> findbyCorreo(String correo);

    Optional<Usuario> findByCui(String cui);

}
