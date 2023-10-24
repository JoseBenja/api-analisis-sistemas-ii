package umg.edu.analisis_ii.sistema_votaciones.client.services;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import umg.edu.analisis_ii.sistema_votaciones.dtos.DataTseDto;

@Service
@Slf4j
@Getter
@Setter
@ConfigurationProperties(prefix = "tse.consumo-ms")
public class TseConsumeService {
    private String pingUrlInterna;
    final static Logger LOG = LoggerFactory.getLogger(TseConsumeService.class);


    public DataTseDto obtenerDataTseDto(String cui) {
        RestTemplate restTemplate = new RestTemplate();
        // Realiza la solicitud GET al endpoint de destino
        ResponseEntity<DataTseDto> responseEntity = restTemplate.getForEntity(pingUrlInterna +"/votante/empadronado/"+ "?cui=" + cui, DataTseDto.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            DataTseDto datosVotante = responseEntity.getBody();
            return  datosVotante;
        } else {
            return null;
        }
    }

}
