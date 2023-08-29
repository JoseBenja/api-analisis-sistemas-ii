package umg.edu.analisis_ii.sistema_votaciones.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import umg.edu.analisis_ii.sistema_votaciones.models.Candidato;
import umg.edu.analisis_ii.sistema_votaciones.projections.CandidatoProjection;

import java.util.List;
/**
 * @author mvracot
 * */
@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    List<Candidato> findByTipoCandidato(String tipoCandidato);

    @Query(value = "select c.id, c.nombre_pres, c.nombre_vice , c.partido_politico , ct.descripcion_catalogo as  imagen_url, c.tipo_candidato \n" +
            "from sistema_votaciones.candidatos c\n" +
            "inner join sistema_votaciones.catalogos ct on c.imagen_url = ct.nombre_catalogo\n" +
            "where c.tipo_candidato = :tipo_candidato ;", nativeQuery = true)
    List<CandidatoProjection> findAllCanditatos(@Param("tipo_candidato") String tipo_candidato);
}

