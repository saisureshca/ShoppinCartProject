import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ShoppingComponent } from './shopping/shopping.component';
import { ProductListComponent } from './shopping/product-list/product-list.component';
import { ProductService } from './shared/product.service';
import { OrderComponent } from './shopping/order/order.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { AppRoutingModule,routingComponents } from './app-routing.module';
import { SubmitOrderComponent } from './submit-order/submit-order.component';
import { SubmittedOrdersComponent } from './submitted-orders/submitted-orders.component';



@NgModule({
  declarations: [
    AppComponent,
    ShoppingComponent,
    ProductListComponent,
    OrderComponent,
    routingComponents,
    SubmitOrderComponent,
    SubmittedOrdersComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    ToastrModule.forRoot()
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
