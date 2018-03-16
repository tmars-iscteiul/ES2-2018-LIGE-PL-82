import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IntrodutionComponent } from './introdution.component';

describe('IntrodutionComponent', () => {
  let component: IntrodutionComponent;
  let fixture: ComponentFixture<IntrodutionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IntrodutionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IntrodutionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
