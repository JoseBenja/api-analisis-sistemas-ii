package umg.edu.analisis_ii.sistema_votaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umg.edu.analisis_ii.sistema_votaciones.models.Catalogo;

import java.util.List;

/**
 * @author mvracot
 * */
@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, String> {
    List<Catalogo> findByTipoCatalogo(String tipoCatalogo);
}