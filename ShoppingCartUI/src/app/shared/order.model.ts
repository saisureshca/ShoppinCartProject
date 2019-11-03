import { Product } from './product.model';

export class Order {

    _id : string;
    product : Product;
    quantity : number;
    status : string;

}
