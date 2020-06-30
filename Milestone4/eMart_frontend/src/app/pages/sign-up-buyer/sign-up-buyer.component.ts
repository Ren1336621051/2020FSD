import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.service';
import { Router } from '@angular/router';

interface Alert {
  type: string;
  message: string;
}

const ALERTS: Alert[] = [];

@Component({
  selector: 'app-sign-up-buyer',
  templateUrl: './sign-up-buyer.component.html',
  styleUrls: ['./sign-up-buyer.component.css']
})
export class SignUpBuyerComponent implements OnInit {

  alerts: Alert[];
  userType: string = "buyer";

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  

  /* 登录操作 */
  onAdd(value: any) {
    value.userType = "buyer";
    if (this.validInput(value)) {
      this.userService.postSignUp(value).subscribe(
        data => {
          console.log(JSON.stringify(data));
          const info: any = data;
          if (0 === info.code) {
              console.log('注册成功，调转登录页');
              alert('Sign up SUCCEED, turn to sign in page.');
              // sessionStorage.setItem('token', info.data.token)
              // //navbar user information
              // sessionStorage.setItem('userkind', info.data.userType)
              // sessionStorage.setItem('username', info.data.userName)
              this.router.navigate(['/sign-in']);
          } else {
            console.log('注册失败，弹出MSG'+info.code);
            this.alerts.push({type : 'danger', message: 'data error!'});

          }
        }
      );
    }
  }
  /* 验证输入项 */
  validInput(value: any): boolean {
    this.reset();
    let result = true
    // if (!value.userName) {
    //   this.alerts.push({type : 'danger', message: 'username required!'});
    //   result = false;
    // }

    // if (!value.password) {
    //   this.alerts.push({type : 'danger', message: 'password required!'});
    //   result =  false;
    // }

    // if (value.password.length < 6) {
    //   this.alerts.push({type : 'danger', message: 'password length must be greater than 6!'});
    //   result =  false;
    // }
    return result;
  }

  close(alert: Alert) {
    this.alerts.splice(this.alerts.indexOf(alert), 1);
  }

  reset() {
    this.alerts = Array.from(ALERTS);
  }

}
