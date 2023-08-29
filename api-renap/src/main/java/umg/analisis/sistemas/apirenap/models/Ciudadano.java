package umg.analisis.sistemas.apirenap.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ciudadano", schema = "renap")
public class Ciudadano implements Serializable {

    @Id
    @Column(name = "cui", length = 13)
    private String cui;

    @Column(name = "primer_nombre", length = 25)
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 25)
    private String segundoNombre;

    @Column(name = "primer_apellido", length = 25)
    private String primerApellido;

    @Column(name = "segundo_apellido", length = 25)
    private String segundoApellido;

    @Column(name = "apellido_casada", length = 25)
    private String apellidoCasada;

    @Column(name = "sexo", length = 1)
    private String sexo;

    @Column(name = "nacionalidad", length = 5)
    private String nacionalidad;

    @Column(name = "pais_nacimiento")
    private Integer paisNacimiento;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "estado_civil", length = 5)
    private String estadoCivil;

    @Column(name = "municipio", length = 5)
    private String municipio;

    @Column(name = "direccion", length = 300)
    private String direccion;

    @Column(name = "fallecido")
    private Boolean fallecido;

    @Column(name = "etnia", length = 20)
    private String etnia;

    @Column(name = "analfabeta")
    private Boolean analfabeta;

    @Column(name = "idioma", length = 30)
    private String idioma;

    @Column(name = "discapacidad", length = 100)
    private String discapacidad;

}
