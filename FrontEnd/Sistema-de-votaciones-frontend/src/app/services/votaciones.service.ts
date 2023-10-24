import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Voto } from '../models/candidato';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class VotacionesService {

  private API_URL = 'https://admon-votaciones-d67c9b4d8c9d.herokuapp.com/votos';

  constructor(private http: HttpClient, private auth: AuthService) { }

  validateUserData(){
    return this.http.get(`${this.API_URL}/verificar-info-usuario?cui=${this.auth.getUserName()}`);
  }

  guardarVotacion(voto: Voto):Observable<Voto> {
    return this.http.post<Voto>(`${this.API_URL}/emitirVotacion`, voto);
  }
}
