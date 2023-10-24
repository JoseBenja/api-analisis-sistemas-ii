import { Component } from '@angular/core';
import {Router} from "@angular/router";
import { AuthService } from 'src/app/services/auth.service';
import { VotacionesService } from 'src/app/services/votaciones.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {

  constructor(private router: Router, private auth: AuthService, private votoService: VotacionesService) {
  }

  rol: string = this.auth.getRol();
  goToAdminPartidos(){
    this.router.navigateByUrl('admin-partidos');
  }

  goToVotations(){
    this.votoService.validateUserData().subscribe((data: any) => {
      console.log(data)
      if(data===true){

        this.router.navigateByUrl('tablero-votacion');
      }else if (data===false){
        Swal.fire({
          title: 'No Empadronado',
          text: 'Aun no estas empadronado.',
          icon: 'warning',
          showConfirmButton: false,
          ///confirmButtonText: 'Ok'
          timer: 3000
        });
      }
    }
    );
  }

}
