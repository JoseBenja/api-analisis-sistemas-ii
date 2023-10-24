package umg.edu.analisis_ii.sistema_votaciones.dtos;

import lombok.Data;

@Data
public class DataRenapDto {
    private String cui;
    private String nombreCompleto;
    private String sexo;
    private String nacionalidad;
    private String fechaNacimiento;
    private String direccionCompleta;
    private String etnia;
    private Boolean analfabeta;
    private String idioma;
    private String discapacidad;
}
