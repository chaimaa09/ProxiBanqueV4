import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsConseillerComponent } from './details-conseiller.component';

describe('DetailsConseillerComponent', () => {
  let component: DetailsConseillerComponent;
  let fixture: ComponentFixture<DetailsConseillerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsConseillerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsConseillerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
