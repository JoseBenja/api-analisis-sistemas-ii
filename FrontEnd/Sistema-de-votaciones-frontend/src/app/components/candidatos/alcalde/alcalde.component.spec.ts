import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlcaldeComponent } from './alcalde.component';

describe('AlcaldeComponent', () => {
  let component: AlcaldeComponent;
  let fixture: ComponentFixture<AlcaldeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AlcaldeComponent]
    });
    fixture = TestBed.createComponent(AlcaldeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
