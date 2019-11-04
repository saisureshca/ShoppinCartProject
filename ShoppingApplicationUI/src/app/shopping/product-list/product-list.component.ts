import { Component, OnInit, Input } from '@angular/core';
import { ProductService } from 'src/app/shared/product.service';
import { Product } from 'src/app/shared/product.model';
import { OrderComponent } from '../order/order.component';
import { Order } from 'src/app/shared/order.model';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {


  productOrdered : Product;
  quantity : number;

  constructor(private service : ProductService,
    private toastr : ToastrService) { }
  

  ngOnInit() {
    this.service.getProducts();
  }
addCart(prod : Product){
  let order = new Order;
  order.product=prod;
  order.quantity=1;
  order.status="PENDING";
  this.service.saveOrder(order);
}

removeCart(prod : Product){
  let order = new Order;
  order.product=prod;
  this.service.removeOrder(order);
}
}
