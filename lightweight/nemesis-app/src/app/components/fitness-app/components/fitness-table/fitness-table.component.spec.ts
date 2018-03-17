import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FitnessTableComponent } from './fitness-table.component';

describe('FitnessTableComponent', () => {
  let component: FitnessTableComponent;
  let fixture: ComponentFixture<FitnessTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FitnessTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FitnessTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
