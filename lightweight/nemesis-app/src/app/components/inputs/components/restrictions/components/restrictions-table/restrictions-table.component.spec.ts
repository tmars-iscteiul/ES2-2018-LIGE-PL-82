import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestrictionsTableComponent } from './restrictions-table.component';

describe('RestrictionsTableComponent', () => {
  let component: RestrictionsTableComponent;
  let fixture: ComponentFixture<RestrictionsTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestrictionsTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestrictionsTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
