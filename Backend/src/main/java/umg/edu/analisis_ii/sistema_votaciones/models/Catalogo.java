package umg.edu.analisis_ii.sistema_votaciones.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
/**
 * @author mvracot
 * */
@Entity
@Table(name = "catalogos", schema = "sistema_votaciones")
@Getter
@Setter
@NoArgsConstructor
public class Catalogo {
    @Id
    @Column(name = "nombre_catalogo", nullable = false)
    private String nombreCatalogo;

    @Column(name = "descripcion_catalogo", nullable = false, columnDefinition = "varchar(255) default 'NA'")
    private String descripcionCatalogo;

    @Column(name = "fecha_creacion", nullable = false)
    private Timestamp fechaCreacion;

    @Column(name = "tipo_catalogo", nullable = false)
    private String tipoCatalogo;

    // Getters and setters
}
