import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  constructor() { }
  public orderItem:any = [{
    id: '2',
    price: 4999,
    title: 'xiaomi 10',
    desc: 'new xiaomi phone',
    pic: '//img.alicdn.com/bao/uploaded/i5/TB1slQyvxD1gK0jSZFKBnQJrVXa_103934.jpg',
    sum: 2,
    updateDate: '2020/05/01',
  
  },{
    id: '3',
    price: 7999,
    title: 'Lenovo Y7000P',
    desc: 'Meet the Lenovo Legion Y7000P, a 15.6" gaming laptop with the latest Intel® Core™ processors and NVIDIA® GeForce RTX™ graphics, white-backlit keyboard, and thermal optimization.',
    pic: '//img.alicdn.com/bao/uploaded/i2/459462135/O1CN01G1qBtC1Rds9j87iIX_!!459462135.jpg',
    sum: 1,
    updateDate: '2020/05/01',
  
  }
]
  ngOnInit() {
  }

}
