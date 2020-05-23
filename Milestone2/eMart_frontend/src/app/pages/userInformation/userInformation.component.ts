import { Component, OnInit } from '@angular/core';


interface UserInformation {
  id: string;
  username: string;
  password: string;
  type:string;
  email: string;
  phone: string;
  address: string;
  creatDate: string;
  website: string;
  GSTIN: string;
  detail: string;
}

@Component({
  selector: 'app-userInformation',
  templateUrl: './userInformation.component.html',
  styleUrls: ['./userInformation.component.css']
})
export class UserInformationComponent implements OnInit {

  constructor() { }
  public userFlg:boolean=true;
  public userDetail:any={
  id: '1001',
  username: 'Tencent',
  password: '123456',
  type:'seller',
  email: '23456789@qq.com',
  phone: '98438732',
  address: 'SHENZHEN,CHINA',
  creatDate: '20200502',
  website: 'www.qq.com',
  gstin: '0.036',
  detail: 'Tencent was established in November 1998 as an internet-based platform company.'
};
  ngOnInit() {
    if(this.userDetail.type=='seller'){
      this.userFlg=false;
    }
  }

}
