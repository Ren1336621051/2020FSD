import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {User} from '../models/user';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  public get currentUserToken(): string {
    return sessionStorage.getItem('token');
  }

  postSignIn(user) {
    return this.http.post(`${environment.baseUrl}/business/login/loginByPassword`, JSON.stringify(user), httpOptions);
  }

  postSignUp(user) {
    return this.http.post(`${environment.baseUrl}/business/regist/addUser`, JSON.stringify(user), httpOptions);
  }

}
