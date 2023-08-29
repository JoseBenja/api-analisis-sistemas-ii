package umg.analisis.sistemas.apitse.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umg.analisis.sistemas.sistemavotaciones.commons.CommonSvcImpl;
import umg.analisis.sistemas.sistemavotaciones.dtos.VotanteDto;
import umg.analisis.sistemas.sistemavotaciones.models.Votante;
import umg.analisis.sistemas.sistemavotaciones.projections.CaracteristicasVotanteProjection;
import umg.analisis.sistemas.sistemavotaciones.repositories.VotanteRepository;
import umg.analisis.sistemas.sistemavotaciones.services.VotanteSvc;

@Service
public class VotanteSvcImpl extends CommonSvcImpl<Votante, VotanteRepository> implements VotanteSvc {

    @Autowired
    VotanteRepository votanteRepository;

    @Override
    public CaracteristicasVotanteProjection getCaracteristicasVotante(VotanteDto votanteDto) {
        try {
            return votanteRepository.getCaracteristicasVotante(votanteDto.getNombre(), votanteDto.getApellido());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
