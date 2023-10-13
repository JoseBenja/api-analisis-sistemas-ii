import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const USER_TOKEN = 'auth-token';
const USER_NAME = 'auth-user';
const USER_ROL = 'auth-rol';
const USER_COMPLETE_NAME = 'auth-complete-name';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  public setToken(token: string): void {
    window.sessionStorage.removeItem(USER_TOKEN);
    window.sessionStorage.setItem(USER_TOKEN, token);
  }

  public getToken(): string {
    return sessionStorage.getItem(USER_TOKEN)!;
  }

  public setUserName(username: string): void {
    window.sessionStorage.removeItem(USER_NAME);
    window.sessionStorage.setItem(USER_NAME, username);
  }

  public getUserName(): string {
    return sessionStorage.getItem(USER_NAME)!;
  }

  public setRol(rol: string): void {
    window.sessionStorage.removeItem(USER_ROL);
    window.sessionStorage.setItem(USER_ROL, rol);
  }

  public getRol(): string {
    return sessionStorage.getItem(USER_ROL)!;
  }

  public getNombre(): string {
    return sessionStorage.getItem(USER_COMPLETE_NAME)!;
  }

  public setNombre(nombreCompleto: string): void {
    window.sessionStorage.removeItem(USER_COMPLETE_NAME);
    window.sessionStorage.setItem(USER_COMPLETE_NAME, nombreCompleto);
  }

  public logOut(): void {
    window.sessionStorage.clear();
  }
}
