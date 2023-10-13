import { Component } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent {

  constructor(private sesionService: AuthService, private router: Router) {
  }
  position: string = 'right';
  logOut(){
    this.sesionService.logOut();
    this.router.navigateByUrl('');
  }

  toppings = new FormControl();

  user = this.sesionService.getNombre();

  toppingList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];

}
