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
@Table(name = "tipo_catalogo", schema = "sistema_votaciones")
@Getter
@Setter
@NoArgsConstructor
public class TipoCatalogo {
    @Id
    @Column(name = "tipo_catalogo", nullable = false)
    private String tipoCatalogo;

    @Column(name = "fecha_creacion", nullable = false)
    private Timestamp fechaCreacion;

    // Getters and setters
}
