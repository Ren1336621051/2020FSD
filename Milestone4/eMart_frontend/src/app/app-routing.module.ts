import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SignInComponent} from './pages/sign-in/sign-in.component';
import { SignUpBuyerComponent } from './pages/sign-up-buyer/sign-up-buyer.component';
import { SignUpSellerComponent } from './pages/sign-up-seller/sign-up-seller.component';
import {ProductComponent} from './pages/product/product.component';
import {MainpageComponent} from './pages/mainpage/mainpage.component';
import {UserInformationComponent} from './pages/userInformation/userInformation.component';
import { ChartComponent } from './pages/chart/chart.component';
import {ProductDetailComponent} from './pages/product-detail/product-detail.component';
import { OrderComponent } from './pages/order/order.component';
import { SellItemComponent } from './pages/sellItem/sellItem.component';
import { CheckoutComponent } from './pages/checkout/checkout.component';
import { AddProductComponent } from './pages/addProduct/addproduct.component';
import {SigninGuard} from './guard/signin.guard';


const routes: Routes = [
  { path: '', component: MainpageComponent},
  { path: 'sign-in', component: SignInComponent},
  { path: 'sign-up-buyer', component: SignUpBuyerComponent},
  { path: 'sign-up-seller', component: SignUpSellerComponent},
  { path: 'chart', component: ChartComponent},
  // { path: 'products', component: ProductComponent, canActivate: [SigninGuard]},
  // { path: 'product/:id', component: ProductDetailComponent, canActivate: [SigninGuard]}
  { path: 'products', component: ProductComponent},
  { path: 'product/:title', component: ProductDetailComponent},
  { path: 'userInformation', component: UserInformationComponent},
  { path: 'order', component: OrderComponent},
  { path: 'sellItem', component: SellItemComponent},
  { path: 'checkout', component: CheckoutComponent},
  { path: 'addProduct', component: AddProductComponent}
];

@NgModule({
  // Registering the RouterModule.forRoot() in the AppModule imports makes the Router service available everywhere in the application.
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
