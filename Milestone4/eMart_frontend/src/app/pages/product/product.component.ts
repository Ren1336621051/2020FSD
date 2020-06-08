import { Component, OnInit,ViewChild } from '@angular/core';
import {ProductService} from '../../services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @ViewChild('searchResult') searchResult:any;
  public products:any;
  constructor(private productService: ProductService) { }


  ngOnInit(): void {
    // this.getDataFromChild();
    // this.productService.allProducts();
    this.allItems();
  }
  // getDataFromChild(){
  //   // alert('ssssss')
  //   this.products=this.searchResult.products;
  //   console.log(this.products);
  // }
  onCal(result:any){
    // this.getDataFromChild();
    this.products=this.searchResult.products;
  }
  allItems(){
    this.productService.allProducts().subscribe(
      data => {
        // const info: any = data;
        this.products = data
      }
    )
  }
}
