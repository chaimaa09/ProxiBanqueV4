import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListConseillerComponent } from './list-conseiller.component';

describe('ListConseillerComponent', () => {
  let component: ListConseillerComponent;
  let fixture: ComponentFixture<ListConseillerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListConseillerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListConseillerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
