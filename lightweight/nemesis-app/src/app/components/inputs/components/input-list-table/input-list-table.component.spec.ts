import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InputListTableComponent } from './input-list-table.component';

describe('InputListTableComponent', () => {
  let component: InputListTableComponent;
  let fixture: ComponentFixture<InputListTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InputListTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InputListTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
