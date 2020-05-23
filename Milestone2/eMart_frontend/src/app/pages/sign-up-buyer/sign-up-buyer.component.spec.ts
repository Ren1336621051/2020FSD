/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { SignUpBuyerComponent } from './sign-up-buyer.component';

describe('SignUpBuyerComponent', () => {
  let component: SignUpBuyerComponent;
  let fixture: ComponentFixture<SignUpBuyerComponent>;

  var form = $('#myForm');
  var result = $('#result');
// '' null undefined  flase
  form.submit(function (e) {
      if(!$('[name=password]').val()){
          // 不推荐在生产项目中写超过3个以上的链式调用
          result.css('display', 'block' ).text('密码为空');
      }else{
          result.css('display', 'none' )
      }
      e.preventDefault();
  })


  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SignUpBuyerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignUpBuyerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
