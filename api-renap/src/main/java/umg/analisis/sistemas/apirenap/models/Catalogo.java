package umg.analisis.sistemas.apirenap.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "catalogo", schema = "renap")
public class Catalogo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_catag")
    private Integer idCatag;

    @Column(name = "tipo", length = 20, nullable = false)
    private String tipo;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @Column(name = "codigo", length = 5, nullable = false)
    private String codigo;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "referencia_id_catag")
    private Integer referenciaIdCatag;

}

