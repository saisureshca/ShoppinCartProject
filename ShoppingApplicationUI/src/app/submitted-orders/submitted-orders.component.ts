import { Component, OnInit } from '@angular/core';
import { ProductService } from '../shared/product.service';

@Component({
  selector: 'app-submitted-orders',
  templateUrl: './submitted-orders.component.html',
  styleUrls: ['./submitted-orders.component.css']
})
export class SubmittedOrdersComponent implements OnInit {

  constructor(private service : ProductService) { }

  ngOnInit() {
    this.service.getSubmittedOrders();
  }

}
