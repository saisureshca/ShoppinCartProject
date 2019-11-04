import { Component, OnInit } from '@angular/core';
import { Order } from '../shared/order.model';
import { ProductService } from '../shared/product.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-submit-order',
  templateUrl: './submit-order.component.html',
  styleUrls: ['./submit-order.component.css']
})
export class SubmitOrderComponent implements OnInit {

  submittedOrder: Order[];
  constructor(private service : ProductService, private toastr : ToastrService)  { }

  ngOnInit() {
    this.service.submitOrders()
    this.toastr.success('Order Submitted Successfully.');
  }

}
