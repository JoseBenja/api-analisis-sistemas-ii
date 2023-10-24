import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CandidatosService {

  private API_URL = 'https://admon-votaciones-d67c9b4d8c9d.herokuapp.com/candidatos';

  constructor(private http: HttpClient) { }

  getCandidatos(tipoCandidato: string):Observable<any> {
    return this.http.get<any>(`${this.API_URL}/por-tipo/${tipoCandidato}`);
    ///por-tipo/PRESIDENTE
  }

}
