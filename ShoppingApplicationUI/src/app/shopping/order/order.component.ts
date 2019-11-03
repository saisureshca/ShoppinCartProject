import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/shared/order.model';
import { ProductService } from 'src/app/shared/product.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  orders: Order[];


  constructor(private service: ProductService,
    private toastr : ToastrService) { }

  ngOnInit() {
    this.service.getOrders();
    this.service.getTotal();
  }
  deleteFromCart(order : Order){
    
    this.service.deleteOrder(order);
    this.service.getOrders();
    this.service.getTotal();
    this.toastr.warning('Deleted From Cart', order.product.productName);
   

  }

  resetOrders(){
    this.service.resetOrders();
    this.service.getOrders();
    this.service.getTotal();
    this.toastr.error('Cart Cleared', ' ');
  }

  public submitOrders(){
    this.service.submitOrders();
    this.toastr.success('Order Submitted Successfully.');
    this.service.getOrders();
    this.service.getTotal();
    
  }
  
}
