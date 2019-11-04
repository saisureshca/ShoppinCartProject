import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmittedOrdersComponent } from './submitted-orders.component';

describe('SubmittedOrdersComponent', () => {
  let component: SubmittedOrdersComponent;
  let fixture: ComponentFixture<SubmittedOrdersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubmittedOrdersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubmittedOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
