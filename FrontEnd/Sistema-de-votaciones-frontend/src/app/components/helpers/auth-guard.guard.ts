import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardGuard implements CanActivate {

  constructor(
    private tokenService: AuthService,
    private router: Router
  ) { }
  canActivate(
    //route: ActivatedRouteSnapshot,
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      const expectedRole = next.data['expectedRole'];
      console.log(expectedRole)
    if (!this.tokenService.getToken()) {
        Swal.fire({
        icon: 'error',
        title: 'Usuario no autenticado',
        text: 'Por favor inicie sesión para continuar',
      })
      this.router.navigate(['']);
      return false;
    }

    if (this.tokenService.getToken() && (this.tokenService.getRol() === expectedRole[0] || this.tokenService.getRol() === expectedRole[1])) {
      console.log('token :' + this.tokenService.getRol() )
      return true;
    } else {
      // Redirige a la página de inicio de sesión si el usuario no tiene acceso
      this.router.navigate(['/unauthorized']);
      return false;
    }
      //return true;
  }


}
