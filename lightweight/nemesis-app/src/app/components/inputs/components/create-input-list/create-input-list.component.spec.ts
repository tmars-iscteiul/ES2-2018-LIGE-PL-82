import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateInputListComponent } from './create-input-list.component';

describe('CreateInputListComponent', () => {
  let component: CreateInputListComponent;
  let fixture: ComponentFixture<CreateInputListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateInputListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateInputListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
