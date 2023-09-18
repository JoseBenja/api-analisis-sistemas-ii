import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CandidatosService {

  private API_URL = 'http://localhost:8091/sistema-votaciones/candidatos';

  constructor(private http: HttpClient) { }

  getCandidatos(tipoCandidato: string):Observable<any> {
    return this.http.get<any>(`${this.API_URL}/por-tipo/${tipoCandidato}`);
    ///por-tipo/PRESIDENTE
  }

}
