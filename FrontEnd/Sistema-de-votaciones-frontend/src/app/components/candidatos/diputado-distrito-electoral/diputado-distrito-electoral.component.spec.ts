import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiputadoDistritoElectoralComponent } from './diputado-distrito-electoral.component';

describe('DiputadoDistritoElectoralComponent', () => {
  let component: DiputadoDistritoElectoralComponent;
  let fixture: ComponentFixture<DiputadoDistritoElectoralComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DiputadoDistritoElectoralComponent]
    });
    fixture = TestBed.createComponent(DiputadoDistritoElectoralComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
