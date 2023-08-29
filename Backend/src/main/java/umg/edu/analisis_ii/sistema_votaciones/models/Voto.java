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
@Table(name = "votos", schema = "sistema_votaciones")
@Getter
@Setter
@NoArgsConstructor
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cui_votante")
    private String cuiVotante;

    @ManyToOne
    @JoinColumn(name = "presidente_id")
    private Candidato presidente;

    @ManyToOne
    @JoinColumn(name = "alcalde_id")
    private Candidato alcalde;

    @ManyToOne
    @JoinColumn(name = "diputado_lista_id")
    private Candidato diputadoLista;

    @ManyToOne
    @JoinColumn(name = "diputado_distrito_id")
    private Candidato diputadoDistrito;

    @ManyToOne
    @JoinColumn(name = "parlacen_id")
    private Candidato parlacen;

    @Column(name = "fecha_voto", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp fechaVoto;

}

