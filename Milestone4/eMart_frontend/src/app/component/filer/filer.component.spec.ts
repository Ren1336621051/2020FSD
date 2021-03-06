/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { FilerComponent } from './filer.component';

describe('FilerComponent', () => {
  let component: FilerComponent;
  let fixture: ComponentFixture<FilerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FilerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
