import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BillAmountComponent } from './bill-amount.component';

describe('BillAmountComponent', () => {
  let component: BillAmountComponent;
  let fixture: ComponentFixture<BillAmountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BillAmountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BillAmountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
