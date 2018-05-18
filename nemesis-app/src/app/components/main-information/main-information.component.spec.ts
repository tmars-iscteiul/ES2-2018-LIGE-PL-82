import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MainInformationComponent } from './main-information.component';

describe('MainInformationComponent', () => {
  let component: MainInformationComponent;
  let fixture: ComponentFixture<MainInformationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MainInformationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MainInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
