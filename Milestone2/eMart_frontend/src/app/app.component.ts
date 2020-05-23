import { Component, OnInit } from '@angular/core';

declare var $: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'eMart demo';
}
export class JqueryExampleComponent implements OnInit {

  constructor() { }
  
  ngOnInit() {
     $(document).ready(function() {
       alert('I am Called From jQuery');
     });
  }
  }
