package umg.edu.analisis_ii.sistema_votaciones.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data
public class UserRole implements Serializable {

    @Id
    private String role;

    private Integer id;

    @Column(name = "generated_date", updatable = false,insertable = false, columnDefinition = "CURRENT_TIMESTAMP Default CURRENT_TIMESTAMP")
    @Temporal(TemporalType.DATE)
    private Date generated_date;
}
