package umg.analisis.sistemas.apirenap.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "dpi", schema = "renap")
public class Dpi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dpi")
    private Integer idDpi;

    @Column(name = "cui", length = 13, nullable = false)
    private String cui;

    @Column(name = "version_dpi", nullable = false)
    private Integer versionDpi;

    @Column(name = "fecha_emision", nullable = false)
    private Date fechaEmision;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

}

