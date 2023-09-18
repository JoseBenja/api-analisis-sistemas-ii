import { Component } from '@angular/core';
import {CandidatosService} from "../../services/candidatos.service";
import {PartidoModel} from "../../models/partido.model";
import {CatalogosService} from "../../services/catalogos.service";
import Swal from 'sweetalert2';

@Component({
  selector: 'app-administrar-partidos',
  templateUrl: './administrar-partidos.component.html',
  styleUrls: ['./administrar-partidos.component.scss']
})
export class AdministrarPartidosComponent {

  constructor(private catalogosSvc: CatalogosService) {
  }

  ngOnInit(): void {
    this.getPartidos();
  }

  displayedColumns: string[] = ['Nombre Partido', 'Descripcion', 'Fecha Creacion', 'Acciones'];


  listPartidos: PartidoModel[]=[];
  getPartidos(){
    this.catalogosSvc.getPartidos().subscribe(data=>{
    this.listPartidos = data;
    console.log(this.listPartidos)
    })
  }

  nombreCatalogo!: string;
  descripcionCatalogo!: string;

  partido: PartidoModel={
    nombreCatalogo: '',
    descripcionCatalogo: '',
    tipoCatalogo: 'PARTIDO_POLITICO'
  }

  async addPartido(){
    const { value: formValues } = await Swal.fire({
      title: 'Crear Partido Politico',
      html:
      '<label for="swal-input1">Nombre:</label>' +
      '<input id="swal-input1" class="swal2-input" required>' +
      '<label for="swal-input2">Descripción:</label>' +
      '<input id="swal-input2" class="swal2-input" required>',
      focusConfirm: false,
      showCancelButton: true,
      showConfirmButton: true,
      confirmButtonText: 'Guardar',
      cancelButtonText: 'Regresar ',



      preConfirm: () => {
        return [
          (<HTMLInputElement>document.getElementById('swal-input1')).value,
          (<HTMLInputElement>document.getElementById('swal-input2')).value
        ]
      },


    })

    if (formValues[0] && formValues[1]) {
      this.partido.nombreCatalogo = formValues[0];
      this.partido.descripcionCatalogo = formValues[1];
      console.log(this.partido);
      if(this.partido.nombreCatalogo.trim().length > 0 && this.partido.descripcionCatalogo.trim().length > 0){
        this.savepatido();
      }else{
        Swal.fire({
          icon: 'error',
          title: 'Parametros Obligatorios',
          text: 'Debe ingresar todos los parametros',
      })
      }


      //Swal.fire(JSON.stringify(formValues))
    }else
      Swal.fire({
        icon: 'error',
        title: 'Parametros Obligatorios',
        text: 'Debe ingresar todos los parametros',
    })

  }

  savepatido(){
    this.catalogosSvc.saveCatalogo(this.partido).subscribe(data=>{
      console.log(data);
      Swal.fire({
        icon: 'success',
        title: 'Partido Politico Creado',
        showConfirmButton: false,
        timer: 1500
      })
      this.getPartidos();
    });
  }

}
