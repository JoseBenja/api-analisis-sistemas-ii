import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TableroVotacionComponent } from './components/tablero-votacion/tablero-votacion.component';
import { TableroVotacionesComponent } from './components/tablero-votaciones/tablero-votaciones.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuardGuard } from './components/helpers/auth-guard.guard';
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {AdministrarPartidosComponent} from "./components/administrar-partidos/administrar-partidos.component";

const routes: Routes = [
  { path: '',  component: LoginComponent },
  { path: 'inicio',  component: DashboardComponent},
  { path: 'admin-partidos',  component: AdministrarPartidosComponent},
  { path: 'tablero-votacion', canActivate:[AuthGuardGuard],component: TableroVotacionesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
