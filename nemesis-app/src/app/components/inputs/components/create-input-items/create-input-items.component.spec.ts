import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateInputItemsComponent } from './create-input-items.component';

describe('CreateInputItemsComponent', () => {
  let component: CreateInputItemsComponent;
  let fixture: ComponentFixture<CreateInputItemsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateInputItemsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateInputItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
