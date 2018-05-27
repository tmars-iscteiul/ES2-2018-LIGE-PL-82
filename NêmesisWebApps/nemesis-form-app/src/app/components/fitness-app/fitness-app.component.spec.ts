import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FitnessAppComponent } from './fitness-app.component';

describe('FitnessAppComponent', () => {
  let component: FitnessAppComponent;
  let fixture: ComponentFixture<FitnessAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FitnessAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FitnessAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
