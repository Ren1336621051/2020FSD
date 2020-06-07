import {Component, DoCheck, OnInit} from '@angular/core';
import {UserService} from '../../services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, DoCheck {

  constructor(private router: Router) { }

   isSignin: boolean;
   buyerflg: boolean;
   username: string;

  ngOnInit(): void {
    if (sessionStorage.getItem('token')){
      this.isSignin = true;
    } else {
      this.isSignin = false;
    }
    //
    if (sessionStorage.getItem('userkind')){
      this.buyerflg = true;
    } else {
      this.buyerflg = false;
    }
    this.username = sessionStorage.getItem('username');
    console.log(this.username);
  }

  ngDoCheck(): void {
    console.log('docheck');
    if (sessionStorage.getItem('token')){
      this.isSignin = true;
    } else {
      this.isSignin = false;
    }
    //
    if (sessionStorage.getItem('userkind')){
      this.buyerflg = true;
    } else {
      this.buyerflg = false;
    }
    this.username = sessionStorage.getItem('username');
  }

  signOut() {
    sessionStorage.removeItem('token');
    this.router.navigate(['/sign-in']);
  }
}
