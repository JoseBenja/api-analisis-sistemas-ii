import { Injectable } from '@angular/core';
import { Candidato, Voto } from 'src/app/models/candidato';
import { AuthService } from './auth.service';
@Injectable({
  providedIn: 'root'
})
export class AlmacenamientoTempService {

  cui: string = this.auth.getUserName();

  presidentes: Candidato[] = [];

  alcaldes:  Candidato[] = [];

  diputadosNacional: Candidato[] = [];

  diputadoDistrito: Candidato[] = [];

  diputadoParlacen: Candidato[] = [];

  constructor(private auth: AuthService) { }

  ultimosCandidatosSeleccionados: { [tipo: string]: Candidato } = {};

  candidatosVotacion!: Voto;


  seleccionarPresidente(index: number) {
    const candidatoSeleccionado = this.presidentes[index];

    console.log(this.presidentes[index]);

    this.presidentes.forEach((candidato, i) => {
      candidato.seleccionado = i === index;
    });

    this.ultimosCandidatosSeleccionados[candidatoSeleccionado.tipo_candidato] = candidatoSeleccionado;
    console.log(this.ultimosCandidatosSeleccionados)
  }


  seleccionarAlcalde(index: number) {
    const candidatoSeleccionado = this.alcaldes[index];

    console.log(this.alcaldes[index]);

    this.alcaldes.forEach((candidato, i) => {
      candidato.seleccionado = i === index;
    });

    this.ultimosCandidatosSeleccionados[candidatoSeleccionado.tipo_candidato] = candidatoSeleccionado;
    console.log(this.ultimosCandidatosSeleccionados)
  }

  seleccionarDiputadoNacional(index: number) {
    const candidatoSeleccionado = this.diputadosNacional[index];

    console.log(this.diputadosNacional[index]);

    this.diputadosNacional.forEach((candidato, i) => {
      candidato.seleccionado = i === index;
    });

    this.ultimosCandidatosSeleccionados[candidatoSeleccionado.tipo_candidato] = candidatoSeleccionado;
    console.log(this.ultimosCandidatosSeleccionados)
  }

  seleccionarDiputadoDistrito(index: number) {
    const candidatoSeleccionado = this.diputadoDistrito[index];

    console.log(this.diputadoDistrito[index]);

    this.diputadoDistrito.forEach((candidato, i) => {
      candidato.seleccionado = i === index;
    });

    this.ultimosCandidatosSeleccionados[candidatoSeleccionado.tipo_candidato] = candidatoSeleccionado;
    console.log(this.ultimosCandidatosSeleccionados)
  }

  seleccionarDiputadoParlacen(index: number) {
    const candidatoSeleccionado = this.diputadoParlacen[index];

    console.log(this.diputadoParlacen[index]);

    this.diputadoParlacen.forEach((candidato, i) => {
      candidato.seleccionado = i === index;
    });

    this.ultimosCandidatosSeleccionados[candidatoSeleccionado.tipo_candidato] = candidatoSeleccionado;
    console.log(this.ultimosCandidatosSeleccionados)
  }

  getUltimosCandidatosSeleccionados() {

    const votoNulo = 13;
    this.candidatosVotacion = {
      cui_votante: this.cui,
      presidente_id: this.ultimosCandidatosSeleccionados['PRESIDENTE']?.id ?? votoNulo,
      alcalde_id: this.ultimosCandidatosSeleccionados['ALCALDE']?.id ?? votoNulo,
      diputado_lista_id: this.ultimosCandidatosSeleccionados['DIPUTADO_NACIONAL']?.id ?? votoNulo,
      diputado_distrito_id: this.ultimosCandidatosSeleccionados['DIPUTADO_DISTRITO']?.id ?? votoNulo,
      parlacen_id: this.ultimosCandidatosSeleccionados['DIPUTADO_PARLACEN']?.id ?? votoNulo,
    };

    console.log(this.candidatosVotacion);
  }



}
