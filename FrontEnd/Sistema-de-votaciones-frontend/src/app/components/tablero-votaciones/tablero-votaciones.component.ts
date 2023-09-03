import { Component, EventEmitter, Output } from '@angular/core';
import {FormBuilder, Validators, FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AlmacenamientoTempService } from 'src/app/services/almacenamiento-temp.service';
import { CandidatosService } from 'src/app/services/candidatos.service';
import { VotacionesService } from 'src/app/services/votaciones.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-tablero-votaciones',
  templateUrl: './tablero-votaciones.component.html',
  styleUrls: ['./tablero-votaciones.component.scss']
})
export class TableroVotacionesComponent {
  @Output() candidatoSeleccionado = new EventEmitter();

  constructor(private _formBuilder: FormBuilder, private candidatosService: CandidatosService, private tempService: AlmacenamientoTempService,
              private votacionService: VotacionesService) {}

  get presidentes () {
    return this.tempService.presidentes;
  }

  set presidentes (value) {
    this.tempService.presidentes = value;
  }

  get ultimosCandidatosSeleccionados () {
    return this.tempService.ultimosCandidatosSeleccionados;
  }

  set ultimosCandidatosSeleccionados (value) {
    this.tempService.ultimosCandidatosSeleccionados = value;
  }

  get alcaldes () {
    return this.tempService.alcaldes;
  }

  set alcaldes (value) {
    this.tempService.alcaldes = value;
  }

  get diputadosNacional () {
    return this.tempService.diputadosNacional;
  }

  set diputadosNacional (value) {
    this.tempService.diputadosNacional = value;
  }

  get diputadoDistrito () {
    return this.tempService.diputadoDistrito;
  }

  set diputadoDistrito (value) {
    this.tempService.diputadoDistrito = value;
  }

  get diputadoParlacen () {
    return this.tempService.diputadoParlacen;
  }

  set diputadoParlacen (value) {
    this.tempService.diputadoParlacen = value;
  }

  get candidatosVotacion () {
    return this.tempService.candidatosVotacion;
  }

  set candidatosVotacion (value) {
    this.tempService.candidatosVotacion = value;
  }



 // ultimosCandidatosSeleccionados: { [tipo: string]: Candidato } = {};

  seleccionarCandidato(index: number) {
    this.tempService.seleccionarPresidente(index);
  }

  seleccionarAlcalde(index: number) {
    this.tempService.seleccionarAlcalde(index);
  }

  seleccionarDiputadoNacional(index: number){
    this.tempService.seleccionarDiputadoNacional(index);
  }

  seleccionarDiputadoDistrito(index: number){
    this.tempService.seleccionarDiputadoDistrito(index);
  }

  seleccionarDiputadoParlacen(index: number){
    this.tempService.seleccionarDiputadoParlacen(index);
  }

  firstFormGroup = this._formBuilder.group({
    firstCtrl: ['', Validators.required],
  });
  secondFormGroup = this._formBuilder.group({
    secondCtrl: ['', Validators.required],
  });
  isEditable = false;





  ngOnInit(): void {
    this.getPresidenciables();
    this.getAlcaldes();
    this.getDiputadosNacional();
    this.getDiputadosDistrito();
    this.getDiputadosParlacen();
  }

  guardarVotacion(){
    this.tempService.getUltimosCandidatosSeleccionados();
    Swal.fire({
      title: '¿Desea Realizar la Votacion?',
      text: 'Esta accion no se puede deshacer',
      icon: 'question',
      showCancelButton: true,
      confirmButtonText: 'Crear',
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      if (result.isConfirmed) {
        this.votacionService.guardarVotacion(this.tempService.candidatosVotacion).subscribe((data: any) => {
            Swal.fire('Votacion Realizada Con Exito.', '', 'success');
          },
          (error: any) => {
            Swal.fire('Error', 'Error al crear la solicitud', 'error');
          }
        );
      }
    });
  }

  getPresidenciables(){
    return this.candidatosService.getCandidatos('PRESIDENTE').subscribe(data=>{
      this.presidentes = data;
      console.log(data);
    });
  }

  getAlcaldes(){
    return this.candidatosService.getCandidatos('ALCALDE').subscribe(data=>{
      this.alcaldes = data;
      console.log(data);
    });
  }

  getDiputadosNacional(){
    return this.candidatosService.getCandidatos('DIPUTADO_NACIONAL').subscribe(data=>{
      this.diputadosNacional = data;
      console.log(data);
    });
  }

  getDiputadosDistrito(){
    return this.candidatosService.getCandidatos('DIPUTADO_DISTRITO').subscribe(data=>{
      this.diputadoDistrito = data;
      console.log(data);
    });
  }


  getDiputadosParlacen(){
    return this.candidatosService.getCandidatos('DIPUTADO_PARLACEN').subscribe(data=>{
      this.diputadoParlacen = data;
      console.log(data);
    });
  }



}
