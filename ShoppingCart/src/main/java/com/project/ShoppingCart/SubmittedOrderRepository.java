package com.project.ShoppingCart;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface SubmittedOrderRepository extends MongoRepository<SubmittedOrder, String>{

}
