import { Injectable } from '@angular/core';
import { Product } from './product.model';
import { HttpClient, HttpParams } from '@angular/common/http'
import { Order } from './order.model';
import { Observable } from 'rxjs/internal/Observable';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  list : Product[];
  order : Order;
  orders : Order[];
  total : number;
  private orderurl: string;
  private saveOrderUrl: string;
  private deleteURL : string;

  constructor(private http: HttpClient) {
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
  console.log(this.total);
}
getOrders(){

  this.http.get(this.orderurl)
  .toPromise().then(res=>this.orders= res as Order[]);
}
resetOrders(){
  this.http.get("http://localhost:8080/api/deleteAlOrders")
  .toPromise().then(result=> console.log(result));
}

submitOrders(){
  this.http.get("http://localhost:8080/api/submitOrders")
  .toPromise().then(result=> console.log(result));
}

public saveOrder(user: Order) {
   this.http.post<Order>(this.saveOrderUrl, user).subscribe((result) => {
  });
}

public deleteOrder(order : Order){
   this.http.post<Order>(this.deleteURL, order).subscribe((result)=>{
  });
}

}
