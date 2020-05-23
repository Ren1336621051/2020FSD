import { Component, OnInit } from '@angular/core';
import Swiper from 'swiper';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {
  title = 'swiper01';

  constructor() { }

  ngOnInit() {
    setTimeout(() => {
      this.initSwiper();
    }, 0);
  }
  initSwiper() {
    const galleryThumbs = new Swiper('.gallery-thumbs', {
      slidesPerView: 2,
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
