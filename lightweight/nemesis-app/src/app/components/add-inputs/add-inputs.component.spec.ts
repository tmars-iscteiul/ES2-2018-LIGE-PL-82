import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddInputsComponent } from './add-inputs.component';

describe('AddInputsComponent', () => {
  let component: AddInputsComponent;
  let fixture: ComponentFixture<AddInputsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddInputsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddInputsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
