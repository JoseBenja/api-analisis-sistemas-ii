import { NgModule } from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { BrowserModule } from '@angular/platform-browser';
import {  FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TableroVotacionComponent } from './components/tablero-votacion/tablero-votacion.component';
import { ImgComponent } from './components/img/img.component';
import { PresidenciableComponent } from './components/candidatos/presidenciable/presidenciable.component';
import { TableroVotacionesComponent } from './components/tablero-votaciones/tablero-votaciones.component';

import {MatStepperModule} from '@angular/material/stepper';
import {MatFormFieldModule} from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { LoginComponent } from './components/login/login.component';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import { Interceptor } from './components/helpers/auth.interceptor';
import {MatToolbarModule} from "@angular/material/toolbar";
import { ToolbarComponent } from './components/toolbar/toolbar.component';
import {MatTooltipModule} from '@angular/material/tooltip';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import {MatSelectModule} from "@angular/material/select";
import { AdministrarPartidosComponent } from './components/administrar-partidos/administrar-partidos.component';
import {MatTableModule} from '@angular/material/table';
@NgModule({
  declarations: [
    AppComponent,
    TableroVotacionComponent,
    ImgComponent,
    PresidenciableComponent,
    TableroVotacionesComponent,
    LoginComponent,
    ToolbarComponent,
    DashboardComponent,
    AdministrarPartidosComponent
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
        HttpClientModule,
        MatCardModule,
        MatIconModule,
        MatToolbarModule,
        MatTooltipModule,
        MatSelectModule,
        MatTableModule
    ],
  providers: [{
    provide: HTTP_INTERCEPTORS,useClass: Interceptor, multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
