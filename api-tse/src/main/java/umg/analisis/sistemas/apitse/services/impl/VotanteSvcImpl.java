package umg.analisis.sistemas.apitse.services.impl;


import org.springframework.stereotype.Service;
import umg.analisis.sistemas.apitse.commons.CommonSvcImpl;
import umg.analisis.sistemas.apitse.models.Votante;
import umg.analisis.sistemas.apitse.projections.DatosVotante;
import umg.analisis.sistemas.apitse.repositories.VotanteRepository;
import umg.analisis.sistemas.apitse.services.VotanteSvc;

@Service
public class VotanteSvcImpl extends CommonSvcImpl<Votante, VotanteRepository> implements VotanteSvc {


    @Override
    public DatosVotante findVotanteByCui(String cui) {
        return this.repository.findVotanteByCui(cui);
    }
}
