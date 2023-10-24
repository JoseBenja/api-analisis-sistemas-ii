package umg.edu.analisis_ii.sistema_votaciones.client.services;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import umg.edu.analisis_ii.sistema_votaciones.dtos.DataRenapDto;
import umg.edu.analisis_ii.sistema_votaciones.dtos.DataTseDto;
import umg.edu.analisis_ii.sistema_votaciones.projections.ConsultaCiudadanoProjection;

@Service
@Slf4j
@Getter
@Setter
@ConfigurationProperties(prefix = "renap.consimo-ms")
public class RenapConsumeService {

    private String urlRenap;
    public DataRenapDto obtenerDataRenap(String cui) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<DataRenapDto> responseEntity = restTemplate.getForEntity(urlRenap + "/buscar-ciudadano/" + "?cui=" + cui, DataRenapDto.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            DataRenapDto datosVotante = responseEntity.getBody();
            return datosVotante;

        } else {
            return null;

        }
    }
}
