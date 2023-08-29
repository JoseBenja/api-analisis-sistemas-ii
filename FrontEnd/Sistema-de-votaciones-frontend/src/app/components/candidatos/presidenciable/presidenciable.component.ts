import { Component, EventEmitter, Input, Output } from '@angular/core';



@Component({
  selector: 'app-presidenciable',
  templateUrl: './presidenciable.component.html',
  styleUrls: ['./presidenciable.component.scss']
})
export class PresidenciableComponent {



  @Input() candidato: any; // O interfaz si tienes una definida

}
