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
  // title = 'swiper01';

  public products:any;
  constructor(private routeInfo: ActivatedRoute,private productService: ProductService) { }
  public itemId:any;

  ngOnInit(): void {
    this.itemId = this.routeInfo.snapshot.params["id"];
    this.products = [];
    console.log("itemName"+this.itemId);
    this.productService.searchById(this.itemId).subscribe(
      data => {
        this.products = JSON.parse(JSON.stringify(data))
        console.log("data"+JSON.stringify(data));
        console.log("products"+this.products.title);
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
