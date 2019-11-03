import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/shared/order.model';
import { ProductService } from 'src/app/shared/product.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  orders: Order[];


  constructor(private service: ProductService) { }

  ngOnInit() {
    this.service.getOrders();
    this.service.getTotal();
  }
  deleteFromCart(order : Order){
    
    this.service.deleteOrder(order);
    this.service.getOrders();
    this.service.getTotal();
   

  }

  resetOrders(){
    this.service.resetOrders();
    this.service.getOrders();
    this.service.getTotal();
  }

  public submitOrders(){
    this.service.submitOrders();
    this.service.getOrders();
    this.service.getTotal();
  }
  
}
