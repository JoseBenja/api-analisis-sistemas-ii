package umg.analisis.sistemas.apitse.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "votante", schema = "tse")
public class Votante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_empadronado")
    private Integer noEmpadronado;

    @Column(name = "cui", length = 13)
    private String cui;

    @Column(name = "municipio")
    private Integer municipio;

    @Column(name = "direccion", length = 100)
    private String direccion;

}
