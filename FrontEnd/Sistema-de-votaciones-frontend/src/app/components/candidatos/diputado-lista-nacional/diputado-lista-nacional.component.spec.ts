import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiputadoListaNacionalComponent } from './diputado-lista-nacional.component';

describe('DiputadoListaNacionalComponent', () => {
  let component: DiputadoListaNacionalComponent;
  let fixture: ComponentFixture<DiputadoListaNacionalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DiputadoListaNacionalComponent]
    });
    fixture = TestBed.createComponent(DiputadoListaNacionalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
