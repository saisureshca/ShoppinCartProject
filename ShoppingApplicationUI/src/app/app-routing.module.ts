import { NgModule } from '@angular/core';
import { Routes,RouterModule } from '@angular/router';
import { SubmitOrderComponent } from './submit-order/submit-order.component';
import { OrderComponent } from './shopping/order/order.component';
import { ProductListComponent } from './shopping/product-list/product-list.component';
import { ShoppingComponent } from './shopping/shopping.component';

const routes : Routes =[
    {path :'', component : ShoppingComponent  },
    {path :'viewCart', component : OrderComponent},
    {path : 'submitOrder', component: SubmitOrderComponent}
];

@NgModule({

    imports : [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule{ }
export const routingComponents =[SubmitOrderComponent,ShoppingComponent,OrderComponent]