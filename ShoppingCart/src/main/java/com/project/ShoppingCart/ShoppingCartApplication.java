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
	        	tv.setDescription("Description: This is a Televison. You can watch movies on this.");
	        	tv.setPhotoLink("./assets/images/tv.png");
	        	list.add(tv);
	        	Product laptop = new Product();
	        	laptop.setProductName("Laptop");
	        	laptop.setProductPrice(399.00);
	        	laptop.setPhotoLink("./assets/images/laptop.png");
	        	laptop.setDescription("Description: This is a Laptop. You can develop software with this.");
	        	list.add(laptop);
	        	Product bag = new Product();
	        	bag.setProductName("Bag");
	        	bag.setProductPrice(59.00);
	        	bag.setDescription("Description: This is a Bag. You can carry things in this.");
	        	bag.setPhotoLink("./assets/images/bag.png");
	        	list.add(bag);
	        	Product book = new Product();
	        	book.setProductName("Book");
	        	book.setProductPrice(29.00);
	        	book.setPhotoLink("./assets/images/book.png");
	        	book.setDescription("Description: This is a Book. You can gain knowledge from this.");
	        	list.add(book);
	        	Product mobile = new Product();
	        	mobile.setProductName("Mobile");
	        	mobile.setProductPrice(850.00);
	        	mobile.setPhotoLink("./assets/images/mobile.png");
	        	mobile.setDescription("Description: This is a Mobile phone. You can make calls with this.");
	        	list.add(mobile);
	        	Product airpods = new Product();
	        	airpods.setProductName("Pods");
	        	airpods.setProductPrice(215.00);
	        	airpods.setPhotoLink("./assets/images/airpods.png");
	        	airpods.setDescription("Description: These are Airpods. Very helpful and compatable with iDevices.");
	        	list.add(airpods);
	        	Product coffee = new Product();
	        	coffee.setProductName("Cup");
	        	coffee.setProductPrice(49.00);
	        	coffee.setPhotoLink("./assets/images/coffee.png");
	        	coffee.setDescription("Description: This is a Cup. You can drink coffee in it.");
	        	list.add(coffee);
	        	Product jacket = new Product();
	        	jacket.setProductName("Jacket");
	        	jacket.setProductPrice(99.00);
	        	jacket.setPhotoLink("./assets/images/jacket.png");
	        	jacket.setDescription("Description: This is a Jacket. It helps you keep warm in winter.");
	        	list.add(jacket);
	        	Product shoes = new Product();
	        	shoes.setProductName("Shoes");
	        	shoes.setProductPrice(69.00);
	        	shoes.setPhotoLink("./assets/images/shoes.png");
	        	shoes.setDescription("Description: This is a pair of shoes. Makes you looks professional.");
	        	list.add(shoes);
	        	Product lamp = new Product();
	        	lamp.setProductName("Lamp");
	        	lamp.setProductPrice(153.00);
	        	lamp.setPhotoLink("./assets/images/lamp.png");
	        	lamp.setDescription("Description: This is a Lamp. It helps you see in the dark.");
	        	list.add(lamp);
	        	Product headphones = new Product();
	        	headphones.setProductName("Headphones");
	        	headphones.setProductPrice(199.00);
	        	headphones.setPhotoLink("./assets/images/headphones.png");
	        	headphones.setDescription("Description: These are Headphones. Helps you listen music.");
	        	list.add(headphones);
	        	Product pillow = new Product();
	        	pillow.setProductName("Pillow");
	        	pillow.setProductPrice(20.00);
	        	pillow.setPhotoLink("./assets/images/pillow.png");
	        	pillow.setDescription("Description: This is a pillow. Helps you sleep well.");
	        	list.add(pillow);
	        	
	        	repository.saveAll(list);
	            repository.findAll().forEach(System.out::println);
	        };
	    }

}
