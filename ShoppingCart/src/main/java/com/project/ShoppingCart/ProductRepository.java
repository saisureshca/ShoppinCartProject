package com.project.ShoppingCart;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
interface ProductRepository extends MongoRepository<Product, String> {

}
