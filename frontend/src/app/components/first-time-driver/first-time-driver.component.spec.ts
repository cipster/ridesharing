import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FirstTimeDriverComponent } from './first-time-driver.component';

describe('FirstTimeDriverComponent', () => {
  let component: FirstTimeDriverComponent;
  let fixture: ComponentFixture<FirstTimeDriverComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FirstTimeDriverComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FirstTimeDriverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
