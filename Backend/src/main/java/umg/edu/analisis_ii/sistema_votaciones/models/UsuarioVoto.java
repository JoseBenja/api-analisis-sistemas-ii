package umg.edu.analisis_ii.sistema_votaciones.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_voto", schema = "sistema_votaciones")
@Getter
@Setter
@NoArgsConstructor
public class UsuarioVoto {

    @Id
    private String cui;

    private String clave;

    private boolean empadronado;

    private String direccion_voto;
}
