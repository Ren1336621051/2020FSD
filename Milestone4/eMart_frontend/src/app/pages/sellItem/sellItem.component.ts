import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sellItem',
  templateUrl: './sellItem.component.html',
  styleUrls: ['./sellItem.component.css']
})
export class SellItemComponent implements OnInit {

  constructor() { }

  public soldFlg:boolean = false;
  public sellItem:any = [{
    id: '3',
    price: 7999,
    title: 'Lenovo Y7000P',
    desc: 'Meet the Lenovo Legion Y7000P, a 15.6" gaming laptop with the latest Intel® Core™ processors and NVIDIA® GeForce RTX™ graphics, white-backlit keyboard, and thermal optimization.',
    pic: '//img.alicdn.com/bao/uploaded/i2/459462135/O1CN01G1qBtC1Rds9j87iIX_!!459462135.jpg',
    sum: 1,
    updateDate: '2020/05/02',
    soldFlg: '1',
    buyer: 'buyer_1',
    transactionNo: 't00001' 
  
  },{
    id: '4',
    price: 7999,
    title: 'Lenovo Thinkpad T490s',
    desc: 'The Lenovo ThinkPad T490s A slim and lightweight body that can run on a battery for a long time. 14.0 type WQHD display, LTE can be selected. It also has robust security and offers high performance.',
    pic: 'https://img.alicdn.com/imgextra/i2/2938620950/O1CN01NEEBbp1It8pygSaGK_!!2938620950.jpg_430x430q90.jpg',
    sum: 1,
    updateDate: '2020/05/02',
    soldFlg: '1',
    buyer: 'buyer_2',
    transactionNo: 't00002' 
  
  }]
  ngOnInit() {
      this.soldFlg=true;
    
  }

}
