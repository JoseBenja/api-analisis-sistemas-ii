import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CatalogosService {
  private API_URL = 'http://localhost:8091/sistema-votaciones/catalogos';

  constructor(private http: HttpClient) { }
  //
  saveCatalogo(catalogo: any): Observable<any> {
    return this.http.post<any>(`${this.API_URL}/crearCatalogo`, catalogo);
  }

  getPartidos():Observable<any> {
    const tipo = 'PARTIDO_POLITICO';
    return this.http.get<any>(`${this.API_URL}/por-tipo/${tipo}`);
  }
}
