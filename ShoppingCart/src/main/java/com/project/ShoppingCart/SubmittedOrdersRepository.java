package com.project.ShoppingCart;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubmittedOrdersRepository extends MongoRepository<SubmittedOrders, String>{
	
	
}
