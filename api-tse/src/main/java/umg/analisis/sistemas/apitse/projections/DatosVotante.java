package umg.analisis.sistemas.apitse.projections;

public interface DatosVotante {

    Integer getNoEmpadronado();

    String getCui();

    String getDireccionCompleta();

    Boolean getVotoEmitido();
}
