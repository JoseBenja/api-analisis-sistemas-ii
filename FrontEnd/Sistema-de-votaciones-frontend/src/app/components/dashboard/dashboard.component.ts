import { Component } from '@angular/core';
import {Router} from "@angular/router";
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {

  constructor(private router: Router, private auth: AuthService) {
  }

  rol: string = this.auth.getRol();
  goToAdminPartidos(){
    this.router.navigateByUrl('admin-partidos');
  }

}
