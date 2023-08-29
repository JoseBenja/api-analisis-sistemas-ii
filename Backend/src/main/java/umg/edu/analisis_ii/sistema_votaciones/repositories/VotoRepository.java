package umg.edu.analisis_ii.sistema_votaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umg.edu.analisis_ii.sistema_votaciones.models.Voto;
/**
 * @author mvracot
 * */
@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
}
