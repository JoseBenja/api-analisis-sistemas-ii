import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TableroVotacionComponent } from './components/tablero-votacion/tablero-votacion.component';
import { TableroVotacionesComponent } from './components/tablero-votaciones/tablero-votaciones.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuardGuard } from './components/helpers/auth-guard.guard';
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {AdministrarPartidosComponent} from "./components/administrar-partidos/administrar-partidos.component";
import { NoAutorizadoComponent } from './components/no-autorizado/no-autorizado.component';

const routes: Routes = [
  { path: '',  component: LoginComponent },
  { path: 'inicio',  canActivate:[AuthGuardGuard], component: DashboardComponent, data: { expectedRole: ['ROLE_ADMIN', 'ROLE_USER'] }},
  { path: 'admin-partidos', canActivate:[AuthGuardGuard], component: AdministrarPartidosComponent, data: { expectedRole: ['ROLE_ADMIN'] } },
  { path: 'tablero-votacion', canActivate:[AuthGuardGuard],component: TableroVotacionesComponent, data: { expectedRole: ['ROLE_ADMIN', 'ROLE_USER'] }},
  { path: 'unauthorized', component: NoAutorizadoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
