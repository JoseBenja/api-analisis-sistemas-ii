import { Component, EventEmitter, Output } from '@angular/core';
import {FormBuilder, Validators, FormsModule, ReactiveFormsModule} from '@angular/forms';
import { CandidatosService } from 'src/app/services/candidatos.service';

interface Candidato {
  id: number;
  nombre_vice: string;
  imagen_url: string;
  nombre_pres: string;
  partido_politico: string;
  tipo_candidato: string;
}
@Component({
  selector: 'app-tablero-votaciones',
  templateUrl: './tablero-votaciones.component.html',
  styleUrls: ['./tablero-votaciones.component.scss']
})
export class TableroVotacionesComponent {
  @Output() candidatoSeleccionado = new EventEmitter();


  candidatos: Candidato[] = [
   /* {
      nombre: 'Bernardo Arevalo',
      partido: 'Semilla',
      edad: 45,
      propuestas: ['Educación gratuita', 'Salud para todos'],
      img: 'https://firebasestorage.googleapis.com/v0/b/analisis-ii.appspot.com/o/Semilla_Party.png?alt=media&token=43f1398e-88bc-45c7-9714-e02468f434e4'
    },
    {
      nombre: 'Sandra Torres',
      partido: 'UNE',
      edad: 50,
      propuestas: ['Empleo juvenil', 'Mejora de infraestructura'],
      img: 'https://firebasestorage.googleapis.com/v0/b/analisis-ii.appspot.com/o/une.png?alt=media&token=0a51e65c-3240-4606-8681-e43b675fd1a7'
    },
    {
      nombre: 'El Chenco',
      partido: 'VAMOS',
      edad: 38,
      propuestas: ['Combate a la corrupción', 'Seguridad ciudadana'],
      img: 'https://firebasestorage.googleapis.com/v0/b/analisis-ii.appspot.com/o/vamos.png?alt=media&token=9e49446a-86c9-4a8a-a840-71df334ea58a'
    },
    {
      nombre: 'Candidato de Valor xD',
      partido: 'VALOR',
      edad: 38,
      propuestas: ['Combate a la corrupción', 'Seguridad ciudadana'],
      img: 'https://firebasestorage.googleapis.com/v0/b/analisis-ii.appspot.com/o/Valor_Logo.png?alt=media&token=c9069560-1aa8-4169-913f-2c7979e10dc0'
    },
    {
      nombre: 'CANDIDATO DE UNIONISTA',
      partido: 'UNIONISTA',
      edad: 38,
      propuestas: ['Combate a la corrupción', 'Seguridad ciudadana'],
      img: 'https://firebasestorage.googleapis.com/v0/b/analisis-ii.appspot.com/o/Partido_Unionista_Logo_(Guatemala%2C_2016).svg%20(1).png?alt=media&token=dc3754eb-b56d-4105-a6e0-9003ce767ca1'
    },
    {
      nombre: 'Candidato de TODOS',
      partido: 'TODOS',
      edad: 38,
      propuestas: ['Combate a la corrupción', 'Seguridad ciudadana'],
      img: 'https://firebasestorage.googleapis.com/v0/b/analisis-ii.appspot.com/o/640px-Partidopoliticotodos.jpg?alt=media&token=311aa6ca-0151-4051-a439-8b891d7889a9'
    }
   */
  ];



  seleccionarCandidato(index: number) {
    this.candidatoSeleccionado.emit(this.candidatos[index]);
    console.log(this.candidatos[index]);
  }

  firstFormGroup = this._formBuilder.group({
    firstCtrl: ['', Validators.required],
  });
  secondFormGroup = this._formBuilder.group({
    secondCtrl: ['', Validators.required],
  });
  isEditable = false;

  constructor(private _formBuilder: FormBuilder, private candidatosService: CandidatosService) {}

  ngOnInit(): void {
    this.getPresidenciables();
  }

  getPresidenciables(){
    return this.candidatosService.getPresidenciables().subscribe(data=>{
      this.candidatos = data;
      console.log(data);
    });
  }
}
