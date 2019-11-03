package com.project.ShoppingCart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;

	
	@GetMapping("/api/allProducts")
    public  List<Product> getProducts() {
        return productRepository.findAll();
    }
	
}
