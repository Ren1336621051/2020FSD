import { Component, OnInit } from '@angular/core';
import {ChartService} from '../../services/chart.service';

// delete
interface ChartItem {
  id: string;
  price: number
  title: string;
  desc: string;
  pic: string;
  sum: number
}
const CHARTITEMS: ChartItem[] = [{
  id: '1',
  price: 3299,
  title: 'iphone se',
  desc: 'iPhone SE packs A13 Bionic, Portrait mode, 4K video, Touch ID, a Retina HD display, and great battery life into a 4.7” design',
  pic: '//img.alicdn.com/bao/uploaded/i1/TB1OtemLpXXXXbvXVXXXXXXXXXX_!!0-item_pic.jpg',
  sum: 3
}, {
  id: '2',
  price: 4999,
  title: 'xiaomi 10',
  desc: 'new xiaomi phone',
  pic: '//img.alicdn.com/bao/uploaded/i1/TB1OtemLpXXXXbvXVXXXXXXXXXX_!!0-item_pic.jpg',
  sum: 2

}
];
// delete
@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
})
export class ChartComponent implements OnInit {

  constructor(private chartService: ChartService) { }

  chartItems: ChartItem[];

  ngOnInit() {
    this.chartService.allProducts().subscribe(data => {
      console.log(JSON.stringify(data));
    })
    this.chartItems = CHARTITEMS;
  }

}
