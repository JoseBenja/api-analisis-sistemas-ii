import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiputadoParlacenComponent } from './diputado-parlacen.component';

describe('DiputadoParlacenComponent', () => {
  let component: DiputadoParlacenComponent;
  let fixture: ComponentFixture<DiputadoParlacenComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DiputadoParlacenComponent]
    });
    fixture = TestBed.createComponent(DiputadoParlacenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
