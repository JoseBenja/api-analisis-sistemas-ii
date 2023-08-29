import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import {  FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TableroVotacionComponent } from './components/tablero-votacion/tablero-votacion.component';
import { ImgComponent } from './components/img/img.component';
import { PresidenciableComponent } from './components/candidatos/presidenciable/presidenciable.component';
import { AlcaldeComponent } from './components/candidatos/alcalde/alcalde.component';
import { DiputadoListaNacionalComponent } from './components/candidatos/diputado-lista-nacional/diputado-lista-nacional.component';
import { DiputadoDistritoElectoralComponent } from './components/candidatos/diputado-distrito-electoral/diputado-distrito-electoral.component';
import { DiputadoParlacenComponent } from './components/candidatos/diputado-parlacen/diputado-parlacen.component';
import { TableroVotacionesComponent } from './components/tablero-votaciones/tablero-votaciones.component';

import {MatStepperModule} from '@angular/material/stepper';
import {MatFormFieldModule} from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
@NgModule({
  declarations: [
    AppComponent,
    TableroVotacionComponent,
    ImgComponent,
    PresidenciableComponent,
    AlcaldeComponent,
    DiputadoListaNacionalComponent,
    DiputadoDistritoElectoralComponent,
    DiputadoParlacenComponent,
    TableroVotacionesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatStepperModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
