import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  allProducts() {
    return this.http.get(`${environment.baseUrl}/product/product`, httpOptions);
  }

  searchByName(name){
    console.log("ssssss"+name);
    return this.http.get(`${environment.baseUrl}/product/product/getItemByName?itemName=`+name, httpOptions);
  }

}



