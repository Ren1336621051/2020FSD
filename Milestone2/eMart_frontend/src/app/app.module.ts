import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {BsDropdownModule} from 'ngx-bootstrap/dropdown';
import { Component, OnInit } from '@angular/core';

// import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
/* bootstrap 按需导入，可以使我们最终的打包文件更小 */
import { NgbAlertModule} from '@ng-bootstrap/ng-bootstrap';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductComponent } from './pages/product/product.component';
import { ProductDetailComponent } from './pages/product-detail/product-detail.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { FooterComponent } from './component/footer/footer.component';
import { ChartComponent } from './pages/chart/chart.component';
import { SignInComponent } from './pages/sign-in/sign-in.component';
import { SignUpBuyerComponent } from './pages/sign-up-buyer/sign-up-buyer.component';
import { SignUpSellerComponent } from './pages/sign-up-seller/sign-up-seller.component';
import { UserInformationComponent } from './pages/userInformation/userInformation.component';
import { OrderComponent } from './pages/order/order.component';
import {MainpageComponent} from './pages/mainpage/mainpage.component';
import {SearchComponent} from './component/search/search.component';
import { SellItemComponent } from './pages/sellItem/sellItem.component';
import { CheckoutComponent } from './pages/checkout/checkout.component';
import { AddProductComponent } from './pages/addProduct/addproduct.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MoneyPipe } from './pipe/money.pipe';
import {JwtInterceptor} from './interceptor/jwt.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    ProductDetailComponent,
    NavbarComponent,
    FooterComponent,
    ChartComponent,
    SignInComponent,
    SignUpBuyerComponent,
    SignUpSellerComponent,
    UserInformationComponent,
    MainpageComponent,
    SearchComponent,
    OrderComponent,
    SellItemComponent,
    CheckoutComponent,
    AddProductComponent,
    MoneyPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbAlertModule,
    FormsModule,
    ReactiveFormsModule,
    BsDropdownModule.forRoot()
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
