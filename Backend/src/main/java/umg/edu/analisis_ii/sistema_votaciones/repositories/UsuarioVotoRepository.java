package umg.edu.analisis_ii.sistema_votaciones.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import umg.edu.analisis_ii.sistema_votaciones.models.UsuarioVoto;

import java.util.Optional;

@Repository
public interface UsuarioVotoRepository extends CrudRepository<UsuarioVoto, String> {


}
