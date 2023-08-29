package umg.analisis.sistemas.apitse.services;


import umg.analisis.sistemas.apitse.commons.CommonSvc;
import umg.analisis.sistemas.apitse.models.Votante;
import umg.analisis.sistemas.apitse.projections.DatosVotante;

public interface VotanteSvc extends CommonSvc<Votante> {

    public DatosVotante findVotanteByCui(String cui);

}
