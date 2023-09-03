package umg.edu.analisis_ii.sistema_votaciones.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author mvracot
 * */
@Entity
@Table(name = "votos", schema = "sistema_votaciones")
@Getter
@Setter
@NoArgsConstructor
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cui_votante")
    private String cui_votante;

    @Column(name = "presidente_id")
    private Integer presidente_id;

    @Column(name = "alcalde_id")
    private Integer alcalde_id;

    @Column(name = "diputado_lista_id")
    private Integer diputado_lista_id;

    @Column(name = "diputado_distrito_id")
    private Integer diputado_distrito_id;

    @Column(name = "parlacen_id")
    private Integer parlacen_id;

    @Column(name = "fecha_voto", insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fecha_voto;

}

