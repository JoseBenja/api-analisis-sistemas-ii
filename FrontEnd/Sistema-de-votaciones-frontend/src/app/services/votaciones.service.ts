import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Voto } from '../models/candidato';

@Injectable({
  providedIn: 'root'
})
export class VotacionesService {

  private API_URL = 'http://localhost:8091/sistema-votaciones/votos';

  constructor(private http: HttpClient) { }

  guardarVotacion(voto: Voto):Observable<Voto> {
    return this.http.post<Voto>(`${this.API_URL}/emitirVotacion`, voto);
  }
}
