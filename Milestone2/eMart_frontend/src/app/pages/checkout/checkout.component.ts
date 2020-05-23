import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  constructor() { }
  public address:any = [{
    recipient: 'Scofield',
    address: '725 5th Ave, New York, NY 10022 America'
  },{
    recipient: 'Akane',
    address: '1 Sotokanda, Chiyoda-ku, Tokyo, Japan'
  },{
    recipient: 'Sakurada',
    address: '1-12-1 Hatagaya, Shibuya-ku, Tokyo 151-0072, Japan'
  }]
  
  public payment:any = [{
    method: 'Visa ',
    cardNo: '876765*****79659'
  },{
    method: 'America Express',
    cardNo: '969765*****79694'
  },{
    method: 'MasterCard',
    cardNo: '230765*****79629'
  }]

  ngOnInit() {
  }

}
