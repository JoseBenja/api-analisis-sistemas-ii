import { Component } from '@angular/core';
import { PartidoModel } from 'src/app/models/partido.model';
import { CatalogosService } from 'src/app/services/catalogos.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-administrar-candidatos',
  templateUrl: './administrar-candidatos.component.html',
  styleUrls: ['./administrar-candidatos.component.scss']
})
export class AdministrarCandidatosComponent {
  
  constructor(private catalogosSvc: CatalogosService) {
  }

  ngOnInit(): void {
    this.getCandidatos();
  }

  displayedColumns: string[] = ['Nombre Partido', 'Descripcion', 'Fecha Creacion', 'Acciones'];


  listCandidatos: PartidoModel[]=[];
  getCandidatos(){
 
  }

  nombreCatalogo!: string;
  descripcionCatalogo!: string;

  candidato: PartidoModel={
    nombreCatalogo: '',
    descripcionCatalogo: '',
    tipoCatalogo: 'CANDIDATO'
  }
  async addCandidato() {
    const { value: formValues } = await Swal.fire({
      title: 'Crear Candidato',
      html:
        '<label for="swal-input1">Nombre Completo:</label>' +
        '<input id="swal-input1" class="swal2-input" required><br><br>' +
        '<label for="swal-input2">Partido político:</label><br>' +
        '<select id="swal-input2" class="swal2-select" required>' +
        '  <option value="partido1">Partido 1</option>' +
        '  <option value="partido2">Partido 2</option>' +
        '  <!-- Agrega más opciones para otros partidos -->' +
        '</select><br><br>' +
        '<label for="swal-input3">Puesto al que se postula:</label>' +
        '<select id="swal-input3" class="swal2-select" required>' +
        '  <option value="puesto1">Puesto 1</option>' +
        '  <option value="puesto2">Puesto 2</option>' +
        '  <!-- Agrega más opciones para otros puestos -->' +
        '</select>',
      focusConfirm: false,
      showCancelButton: true,
      showConfirmButton: true,
      confirmButtonText: 'Guardar',
      cancelButtonText: 'Regresar',
      preConfirm: () => {
        return [
          (<HTMLInputElement>document.getElementById('swal-input1')).value,
          (<HTMLSelectElement>document.getElementById('swal-input2')).value,
          (<HTMLSelectElement>document.getElementById('swal-input3')).value
        ];
      }
    });
  }
  
  

  saveCandidato(){
      Swal.fire({
        icon: 'success',
        title: 'Candidato Creado',
        showConfirmButton: false,
        timer: 1500
      })
  }

}

