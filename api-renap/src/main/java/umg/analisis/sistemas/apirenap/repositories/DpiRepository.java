package umg.analisis.sistemas.apirenap.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import umg.analisis.sistemas.apirenap.models.Dpi;
import umg.analisis.sistemas.apirenap.projections.ConsultaCiudadanoProjection;

public interface DpiRepository extends CrudRepository<Dpi, Object> {

    @Query(value = "SELECT " +
            "c.cui as cui, " +
            "c.primer_nombre || ' ' || c.segundo_nombre || ' ' || c.primer_apellido || ' ' || c.segundo_apellido as nombreCompleto, " +
            "c.sexo as sexo, " +
            "c.nacionalidad as nacionalidad, " +
            "c.fecha_nacimiento as fechaNacimiento, " +
            "c.direccion || ', ' || c2.nombre || ', ' || c3.nombre || ', ' || c4.nombre as direccionCompleta," +
            "c.etnia as etnia, " +
            "c.analfabeta as analfabeta, " +
            "c.idioma as idioma, " +
            "c.discapacidad as discapacidas " +
            "FROM renap.ciudadano c " +
            "INNER JOIN renap.dpi d ON c.cui = d.cui " +
            "INNER JOIN renap.catalogo c2 ON c.municipio = c2.id_catag " +
            "INNER JOIN renap.catalogo c3 ON c2.referencia_id_catag = c3.id_catag " +
            "INNER JOIN renap.catalogo c4 ON c3.referencia_id_catag = c4.id_catag " +
            "WHERE " +
            "c.cui = :dpi " +
            "AND c.fallecido = false " +
            "AND d.activo = true " +
            "AND c.fecha_nacimiento < '2004-12-31'",
            nativeQuery = true)
    public ConsultaCiudadanoProjection getDatosSolteroConSegundoNombre(@Param("dpi") String dpi);

    @Query(value = "SELECT " +
            "c.cui as cui, " +
            "c.primer_nombre || ' ' || c.segundo_nombre || ' ' || c.primer_apellido || ' ' || c.segundo_apellido || ' ' || c.apellido_casada as nombreCompleto, " +
            "c.sexo as sexo, " +
            "c.nacionalidad as nacionalidad, " +
            "c.fecha_nacimiento as fechaNacimiento, " +
            "c.direccion || ', ' || c2.nombre || ', ' || c3.nombre || ', ' || c4.nombre as direccionCompleta," +
            "c.etnia as etnia, " +
            "c.analfabeta as analfabeta, " +
            "c.idioma as idioma, " +
            "c.discapacidad as discapacidas " +
            "FROM renap.ciudadano c " +
            "INNER JOIN renap.dpi d ON c.cui = d.cui " +
            "INNER JOIN renap.catalogo c2 ON c.municipio = c2.id_catag " +
            "INNER JOIN renap.catalogo c3 ON c2.referencia_id_catag = c3.id_catag " +
            "INNER JOIN renap.catalogo c4 ON c3.referencia_id_catag = c4.id_catag " +
            "WHERE " +
            "c.cui = :dpi " +
            "AND c.fallecido = false " +
            "AND d.activo = true " +
            "AND c.fecha_nacimiento < '2004-12-31'",
            nativeQuery = true)
    public ConsultaCiudadanoProjection getDatosCasadaConSegundoNombre(@Param("dpi") String dpi);

    @Query(value = "SELECT " +
            "c.cui as cui, " +
            "c.primer_nombre || ' ' || c.primer_apellido || ' ' || c.segundo_apellido as nombreCompleto, " +
            "c.sexo as sexo, " +
            "c.nacionalidad as nacionalidad, " +
            "c.fecha_nacimiento as fechaNacimiento, " +
            "c.direccion || ', ' || c2.nombre || ', ' || c3.nombre || ', ' || c4.nombre as direccionCompleta," +
            "c.etnia as etnia, " +
            "c.analfabeta as analfabeta, " +
            "c.idioma as idioma, " +
            "c.discapacidad as discapacidas " +
            "FROM renap.ciudadano c " +
            "INNER JOIN renap.dpi d ON c.cui = d.cui " +
            "INNER JOIN renap.catalogo c2 ON c.municipio = c2.id_catag " +
            "INNER JOIN renap.catalogo c3 ON c2.referencia_id_catag = c3.id_catag " +
            "INNER JOIN renap.catalogo c4 ON c3.referencia_id_catag = c4.id_catag " +
            "WHERE " +
            "c.cui = :dpi " +
            "AND c.fallecido = false " +
            "AND d.activo = true " +
            "AND c.fecha_nacimiento < '2004-12-31'",
            nativeQuery = true)
    public ConsultaCiudadanoProjection getDatosSolteroSinSegundoNombre(@Param("dpi") String dpi);

    @Query(value = "SELECT " +
            "c.cui as cui, " +
            "c.primer_nombre || ' ' || c.primer_apellido || ' ' || c.segundo_apellido || ' ' || c.apellido_casada as nombreCompleto, " +
            "c.sexo as sexo, " +
            "c.nacionalidad as nacionalidad, " +
            "c.fecha_nacimiento as fechaNacimiento, " +
            "c.direccion || ', ' || c2.nombre || ', ' || c3.nombre || ', ' || c4.nombre as direccionCompleta," +
            "c.etnia as etnia, " +
            "c.analfabeta as analfabeta, " +
            "c.idioma as idioma, " +
            "c.discapacidad as discapacidas " +
            "FROM renap.ciudadano c " +
            "INNER JOIN renap.dpi d ON c.cui = d.cui " +
            "INNER JOIN renap.catalogo c2 ON c.municipio = c2.id_catag " +
            "INNER JOIN renap.catalogo c3 ON c2.referencia_id_catag = c3.id_catag " +
            "INNER JOIN renap.catalogo c4 ON c3.referencia_id_catag = c4.id_catag " +
            "WHERE " +
            "c.cui = :dpi " +
            "AND c.fallecido = false " +
            "AND d.activo = true " +
            "AND c.fecha_nacimiento < '2004-12-31'",
            nativeQuery = true)
    public ConsultaCiudadanoProjection getDatosCasadaSinSegundoNombre(@Param("dpi") String dpi);

    @Query(value = "SELECT EXISTS (" +
            " SELECT " +
            " c.estado_civil" +
            " FROM renap.ciudadano c " +
            " WHERE c.cui = :dpi " +
            " AND c.estado_civil = 'C' " +
            " AND c.sexo = 'F' " +
            ")",
            nativeQuery = true)
    public Boolean validarEstadoCivil(@Param("dpi") String dpi);

    @Query(value = "SELECT EXISTS (" +
            " SELECT " +
            " c.segundo_nombre" +
            " FROM renap.ciudadano c " +
            " WHERE c.cui = :dpi " +
            " AND c.segundo_nombre IS NULL " +
            ")", nativeQuery = true)
    public Boolean validarSegundoApellidoExist(@Param("dpi") String dpi);
}
