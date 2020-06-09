import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Route} from '@angular/router';
import {ProductService} from '../../services/product.service';
import Swiper from 'swiper';
import * as $ from 'jquery';

// interface ProductItem1 {
//   id: string;
//   price: number
//   title: string;
//   desc: string;
//   pic: string;
//   size: string;
// }
// const PRODUCTS: ProductItem1[] = [{
//   id: '1',
//   price: 3299,
//   title: 'iphone se',
//   desc: 'iPhone SE packs A13 Bionic, Portrait mode, 4K video, Touch ID, a Retina HD display, and great battery life into a 4.7” design',
//   pic: 'https://img.alicdn.com/imgextra/i4/713805254/O1CN01u8jB1g1ogNWXlcBpm_!!713805254.jpg_430x430q90.jpg',
//   size:'red 128G'
// }];

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  title = 'swiper01';

  constructor(private routeInfo: ActivatedRoute,private productService: ProductService) { }
  public products:any
  // ={
  //   id: '1',
  //   price: 3299,
  //   title: 'iphone se',
  //   desc: 'iPhone SE packs A13 Bionic, Portrait mode, 4K video, Touch ID, a Retina HD display, and great battery life into a 4.7” design',
  //   pic: 'https://img.alicdn.com/imgextra/i4/713805254/O1CN01u8jB1g1ogNWXlcBpm_!!713805254.jpg_430x430q90.jpg',
  //   size:'red 128G'
  // }
  itemName: string

  ngOnInit(): void {
    // console.log(JSON.stringify(this.route));
    // this.products=PRODUCTS;
    console.log(this.products);
    this.itemName = this.routeInfo.snapshot.params['title'];

    this.productService.searchByName(this.itemName).subscribe(
      data => {
        // const info: any = data;
        this.products = data
      });

    setTimeout(() => {
      this.initSwiper();
    }, 0);
// Qty component start
    $(function(){    
      var t:any = $("#quantity");    
      $("#add").click(function(){    
          t.val(parseInt(t.val())+1);    
          $("#min").removeAttr("disabled");                 //当按加1时，解除$("#min")不可读状态    
          setTotal();    
      })    
      $("#min").click(function(){    
                 if (parseInt(t.val())>1) {                     //判断数量值大于1时才可以减少    
                  t.val(parseInt(t.val())-1)    
                  }else{    
                  $("#min").attr("disabled","disabled")        //当$("#min")为1时，$("#min")不可读状态    
                 }    
          setTotal();    
      })    
      function setTotal(){    
          $("#total").html((parseInt(t.val())*3.95).toFixed(2));    
      }    
      setTotal();    
  })  
  
// Qty component end
  }
  initSwiper() {
    const galleryThumbs = new Swiper('.gallery-thumbs', {
      slidesPerView: 4,
      freeMode: true,
      watchSlidesVisibility: true,
      watchSlidesProgress: true,
    });

    const galleryTop = new Swiper('.gallery-top', {
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
      thumbs: {
        swiper: galleryThumbs
      }
    });
    
  }
  


}
