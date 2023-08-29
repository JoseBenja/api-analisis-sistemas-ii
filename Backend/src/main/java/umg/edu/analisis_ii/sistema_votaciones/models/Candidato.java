package umg.edu.analisis_ii.sistema_votaciones.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
/**
 * @author mvracot
 * */
@Entity
@Table(name = "candidatos", schema = "sistema_votaciones")
@Getter
@Setter
@NoArgsConstructor
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_pres", nullable = false)
    private String nombrePres;

    @Column(name = "nombre_vice")
    private String nombreVice;

    @Column(name = "partido_politico")
    private String partidoPolitico;

    @Column(name = "imagen_url")
    private String imagenUrl;

    @Column(name = "tipo_candidato", nullable = false)
    private String tipoCandidato;

    // Getters and setters
}

