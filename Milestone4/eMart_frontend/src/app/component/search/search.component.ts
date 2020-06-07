import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { ProductService } from '../../services/product.service';

interface ProductItem {
  id: string;
  price: number
  title: string;
  desc: string;
  pic: string;
}
const PRODUCTS: ProductItem[] = [{
  id: '1',
  price: 3299,
  title: 'iphone se',
  desc: 'iPhone SE packs A13 Bionic, Portrait mode, 4K video, Touch ID, a Retina HD display, and great battery life into a 4.7” design',
  pic: 'https://img.alicdn.com/imgextra/i4/713805254/O1CN01u8jB1g1ogNWXlcBpm_!!713805254.jpg_430x430q90.jpg'
}, {
  id: '2',
  price: 4999,
  title: 'xiaomi 10',
  desc: 'new xiaomi phone',
  pic: '//img.alicdn.com/bao/uploaded/i1/TB1OtemLpXXXXbvXVXXXXXXXXXX_!!0-item_pic.jpg'
}, {
  id: '3',
  price: 4999,
  title: 'xiaomi 10',
  desc: 'new xiaomi phone',
  pic: '////img.alicdn.com/bao/uploaded/i1/TB1OtemLpXXXXbvXVXXXXXXXXXX_!!0-item_pic.jpg'
}, {
  id: '4',
  price: 4999,
  title: 'xiaomi 10',
  desc: 'new xiaomi phone',
  pic: '//img.alicdn.com/bao/uploaded/i1/TB1OtemLpXXXXbvXVXXXXXXXXXX_!!0-item_pic.jpg'
}, {
  id: '5',
  price: 4999,
  title: 'xiaomi 10',
  desc: 'new xiaomi phone',
  pic: '//img.alicdn.com/bao/uploaded/i1/TB1OtemLpXXXXbvXVXXXXXXXXXX_!!0-item_pic.jpg'
}
];

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  public products: ProductItem[];

  @Output() result = new EventEmitter<string>();

  constructor(private productService: ProductService) { }

  ngOnInit() {
    // this.products = PRODUCTS;
    // console.log(this.products);
    this.searchByName(null);
    // this.result.emit('search');
  }

  searchByName(value: any) {
    this.productService.searchByName(value).subscribe(data => {
      console.log(JSON.stringify(data));
    })

    this.products = PRODUCTS;

    this.result.emit('search');

  }
  searchByFiler(value:any){

  }

}
