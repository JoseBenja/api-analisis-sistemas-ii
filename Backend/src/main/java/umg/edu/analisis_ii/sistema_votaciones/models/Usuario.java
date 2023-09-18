package umg.edu.analisis_ii.sistema_votaciones.models;

//  import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "usuarios", schema = "sistema_votaciones")
@NoArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id_usuario;

    @Column(name= "cui", nullable = false,unique = true)
    private String cui;

    @Column(name= "nombre", nullable = false)
    private String nombre;

    @Column(name= "correo",unique = true, nullable = false)
    private String correo;

    @Column(name= "estado", nullable = false)
    private boolean estado;

    @Column(name = "fecha_creacion", updatable = false,insertable = false, columnDefinition = "CURRENT_TIMESTAMP Default CURRENT_TIMESTAMP")
    //@JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion;

    @Column(name = "fecha_modificacion", insertable = false)
    //@JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date fecha_modificacion;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="rol", nullable = false)
    private String rol;

}
