package umg.analisis.sistemas.apitse.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import umg.analisis.sistemas.apitse.models.Votante;
import umg.analisis.sistemas.apitse.projections.DatosVotante;

public interface VotanteRepository extends CrudRepository<Votante, Object> {


    @Query(value = "SELECT " +
            "v.no_empadronado AS noEmpadronado," +
            "v.cui AS cui," +
            "c4.nombre || ', ' || c3.nombre || ', ' || c2.nombre || ', ' || v.direccion AS direccionCompleta " +
            "FROM tse.votante v " +
            "INNER JOIN tse.catalogo c2 ON v.municipio = c2.id_catag " +
            "INNER JOIN tse.catalogo c3 ON c2.referencia_id_catag = c3.id_catag " +
            "INNER JOIN tse.catalogo c4 ON c3.referencia_id_catag = c4.id_catag  " +
            "WHERE v.cui = :cui ",
            nativeQuery = true)
    public DatosVotante findVotanteByCui(@Param("cui") String cui);
}
