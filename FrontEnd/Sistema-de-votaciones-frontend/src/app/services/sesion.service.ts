import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { token, usuarioDTO } from '../models/usuario.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SesionService {
  private baseURL:string = 'https://admon-votaciones-d67c9b4d8c9d.herokuapp.com/auth/authenticate';
  constructor(private http: HttpClient) { }

  obtenerToken(usuario:usuarioDTO): Observable<token> {
    return this.http.post<token>(`${this.baseURL}`, usuario);

  }
}
