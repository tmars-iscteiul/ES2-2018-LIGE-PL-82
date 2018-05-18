import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InputsNameTableComponent } from './inputs-name-table.component';

describe('InputsNameTableComponent', () => {
  let component: InputsNameTableComponent;
  let fixture: ComponentFixture<InputsNameTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InputsNameTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InputsNameTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
