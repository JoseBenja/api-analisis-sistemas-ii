package umg.analisis.sistemas.apitse.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "votante", schema = "sistema_votaciones")
public class Votante {

    @Id
    @Column(name = "dpi", length = 13)
    private String dpi;

    @Column(name = "no_empradronamiento", length = 50)
    private String noEmpradonado;

    @Column(name = "domicilio", length = 200)
    private String domicilio;

    @Column(name = "estado_votacion")
    private Boolean estadoVotacion;

    @Column(name = "etnia", length = 30)
    private String etnia;

    @Column(name = "analfabeta")
    private Boolean analfabeta;

    @Column(name = "discapacidad", length = 100)
    private String discapacidad;

    @Column(name = "estado_votante")
    private Boolean estadoVotante;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "apellido", length = 50)
    private String apellido;

    @Column(name = "sexo", length = 1)
    private String sexo;
}
