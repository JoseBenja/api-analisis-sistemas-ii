import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { usuarioDTO } from 'src/app/models/usuario.model';
import { AuthService } from 'src/app/services/auth.service';
import { SesionService } from 'src/app/services/sesion.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  hide = true;

  usuario: usuarioDTO ={
    username:'',
    password: '',
  }
  constructor(private formBuilder:FormBuilder, private sesionService:SesionService, private authService:AuthService, private router: Router) {
    this.loginForm();
  }

  form!:FormGroup;
  mensajeUsernameRequerido:string='El campo es obligatorio, por favor ingrese su correo';
  mensajePasswordRequerido:string='El campo es obligatorio, por favor ingrese su contrasenia';
  ngOnInit(): void {
    //
  }

  private loginForm(){
    this.form= this.formBuilder.group({
      usuario:['', Validators.required],
      password:['',Validators.required]
    })
  }

  login(){
    console.log(this.form.value);

    const sesion:usuarioDTO={
      username:this.form.get('usuario')?.value,
      password:this.form.get('password')?.value
    }

    this.sesionService.obtenerToken(sesion).subscribe(token=>{
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Bienvenido ' + this.form.get('usuario')?.value,
        showConfirmButton: false,
        timer: 1500
      })

      this.authService.setToken(token.jwt);
      this.authService.setUserName(token.nombre);
      this.router.navigateByUrl('inicio');
    },error => Swal.fire('ERROR', `El usuario o contraseña son incorrectos por favor intente de nuevo`, `error`))
  }

  get usernameField(){
    return this.form.get('username');
  }

  get passwordField(){
    return this.form.get('password');
  }

}
