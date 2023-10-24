import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministrarCandidatosComponent } from './administrar-candidatos.component';

describe('AdministrarCandidatosComponent', () => {
  let component: AdministrarCandidatosComponent;
  let fixture: ComponentFixture<AdministrarCandidatosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdministrarCandidatosComponent]
    });
    fixture = TestBed.createComponent(AdministrarCandidatosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
