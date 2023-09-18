package umg.edu.analisis_ii.sistema_votaciones.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import umg.edu.analisis_ii.sistema_votaciones.models.Usuario;


import java.util.Optional;

@Repository
public interface UsuarioRepo extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByCorreo(String correo);

    Optional<Usuario> findByCui(String cui);
}