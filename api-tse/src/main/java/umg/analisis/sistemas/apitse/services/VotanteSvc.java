package umg.analisis.sistemas.apitse.services;

import umg.analisis.sistemas.sistemavotaciones.commons.CommonSvc;
import umg.analisis.sistemas.sistemavotaciones.dtos.VotanteDto;
import umg.analisis.sistemas.sistemavotaciones.models.Votante;
import umg.analisis.sistemas.sistemavotaciones.projections.CaracteristicasVotanteProjection;

public interface VotanteSvc extends CommonSvc<Votante> {

    public CaracteristicasVotanteProjection getCaracteristicasVotante(VotanteDto votanteDto);
}
