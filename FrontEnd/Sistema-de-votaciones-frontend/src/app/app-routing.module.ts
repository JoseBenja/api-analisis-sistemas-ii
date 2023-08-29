import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TableroVotacionComponent } from './components/tablero-votacion/tablero-votacion.component';
import { TableroVotacionesComponent } from './components/tablero-votaciones/tablero-votaciones.component';

const routes: Routes = [
  { path: 'tablero-votacion', component: TableroVotacionesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
