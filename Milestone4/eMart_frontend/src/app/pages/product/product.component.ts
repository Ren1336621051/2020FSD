import { Component, OnInit,ViewChild } from '@angular/core';
import {ProductService} from '../../services/product.service';

interface ProductItem {
  id: string;
  price: number
  title: string;
  desc: string;
  pic: string;
}

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @ViewChild('searchResult') searchResult:any;
  public products: ProductItem[];
  constructor(private productService: ProductService) { }


  ngOnInit(): void {
    this.getDataFromChild();
    this.productService.allProducts();
  }
  getDataFromChild(){
    // alert('ssssss')
    this.products=this.searchResult.products;
    console.log(this.searchResult.products)
  }
  onCal(result:string){
    this.getDataFromChild();
  }
}
