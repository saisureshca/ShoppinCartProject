package com.project.ShoppingCart;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

	 @Bean
	    ApplicationRunner init(ProductRepository repository, OrderRepository orderRepo) {
	        return args -> {
	        	repository.deleteAll();
	        	orderRepo.deleteAll();
	        	List<Product> list = new ArrayList<Product>();
	        	Product tv = new Product();
	        	tv.setProductName("Televison");
	        	tv.setProductPrice(499.00);
	        	tv.setDescription("This is a Product");
	        	tv.setPhotoLink("./assets/images/tv.png");
	        	list.add(tv);
	        	Product laptop = new Product();
	        	laptop.setProductName("Laptop");
	        	laptop.setProductPrice(399.00);
	        	laptop.setPhotoLink("./assets/images/laptop.png");
	        	laptop.setDescription("This is a Product");
	        	list.add(laptop);
	        	Product bag = new Product();
	        	bag.setProductName("Bag");
	        	bag.setProductPrice(59.00);
	        	bag.setDescription("This is a Product");
	        	bag.setPhotoLink("./assets/images/bag.png");
	        	list.add(bag);
	        	Product book = new Product();
	        	book.setProductName("Book");
	        	book.setProductPrice(29.00);
	        	book.setPhotoLink("./assets/images/book.png");
	        	book.setDescription("This is a Product");
	        	list.add(book);
	        	Product mobile = new Product();
	        	mobile.setProductName("Mobile");
	        	mobile.setProductPrice(850.00);
	        	mobile.setPhotoLink("./assets/images/mobile.png");
	        	mobile.setDescription("This is a Product");
	        	list.add(mobile);
	        	Product airpods = new Product();
	        	airpods.setProductName("Pods");
	        	airpods.setProductPrice(215.00);
	        	airpods.setPhotoLink("./assets/images/airpods.png");
	        	airpods.setDescription("This is a Product");
	        	list.add(airpods);
	        	Product coffee = new Product();
	        	coffee.setProductName("Cup");
	        	coffee.setProductPrice(49.00);
	        	coffee.setPhotoLink("./assets/images/coffee.png");
	        	coffee.setDescription("This is a Product");
	        	list.add(coffee);
	        	Product jacket = new Product();
	        	jacket.setProductName("Jacket");
	        	jacket.setProductPrice(99.00);
	        	jacket.setPhotoLink("./assets/images/jacket.png");
	        	jacket.setDescription("This is a Product");
	        	list.add(jacket);
	        	Product shoes = new Product();
	        	shoes.setProductName("Shoes");
	        	shoes.setProductPrice(69.00);
	        	shoes.setPhotoLink("./assets/images/shoes.png");
	        	shoes.setDescription("This is a Product");
	        	list.add(shoes);
	        	Product lamp = new Product();
	        	lamp.setProductName("Lamp");
	        	lamp.setProductPrice(153.00);
	        	lamp.setPhotoLink("./assets/images/lamp.png");
	        	lamp.setDescription("This is a Product");
	        	list.add(lamp);
	        	Product headphones = new Product();
	        	headphones.setProductName("Headphones");
	        	headphones.setProductPrice(199.00);
	        	headphones.setPhotoLink("./assets/images/headphones.png");
	        	headphones.setDescription("This is a Product");
	        	list.add(headphones);
	        	Product pillow = new Product();
	        	pillow.setProductName("Pillow");
	        	pillow.setProductPrice(20.00);
	        	pillow.setPhotoLink("./assets/images/pillow.png");
	        	pillow.setDescription("This is a Product");
	        	list.add(pillow);
	        	
	        	repository.saveAll(list);
	            repository.findAll().forEach(System.out::println);
	        };
	    }

}
