import { Injectable } from '@angular/core';
import { Product } from './product.model';
import { HttpClient, HttpParams } from '@angular/common/http'
import { Order } from './order.model';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  list : Product[];
  order : Order;
  orders : Order[];
  submittedOrder : Order[];
  total : number;
  orderHistory : Order[];
  removed : boolean;
  private orderurl: string;
  private saveOrderUrl: string;
  private deleteURL : string;

  constructor(private http: HttpClient, private tostar : ToastrService) {
    this.orderurl = "http://localhost:8080/api/getOrders"
    this.saveOrderUrl = "http://localhost:8080/api/addOrder";
    this.deleteURL = "http://localhost:8080/api/deleteOrder";

   }

getProducts(){

  this.http.get("http://localhost:8080/api/allProducts")
  .toPromise().then(res=>this.list= res as Product[]);
}
getTotal(){
  this.http.get("http://localhost:8080/api/getTotal")
  .toPromise().then(res=>this.total= res as number);
}
getOrders(){

  this.http.get(this.orderurl)
  .toPromise().then(res=>this.orders= res as Order[]);
}
resetOrders(){
  this.http.get("http://localhost:8080/api/deleteAlOrders")
  .toPromise().then(result=> result);
}

submitOrders(){
  this.http.get("http://localhost:8080/api/submitOrders")
  .toPromise().then(result=> this.submittedOrder = result as Order[]);
}

saveOrder(user: Order) {
   this.http.post<Order>(this.saveOrderUrl, user).subscribe(result=> result );
   this.getOrders();
   this.getTotal();
}
removeOrder(user: Order) {
  this.http.post<boolean>("http://localhost:8080/api/removeOrder", user).subscribe(result=> {if(result){this.tostar.error('Item not in cart',user.product.productName);}});
  this.getOrders();
  this.getTotal();
}
deleteOrder(order : Order){
   this.http.post<Order>(this.deleteURL, order).subscribe(result=>result);
}

getSubmittedOrders(){
  this.http.get("http://localhost:8080/api/finishedOrders")
  .toPromise().then(result=> this.orderHistory = result as Order[]);
}

}
