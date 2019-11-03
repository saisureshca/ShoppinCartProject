package com.project.ShoppingCart;


import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
@Document(collection = "products")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Product {

	   	@Id
	    private String _id;
	    private @NonNull String productName;
	    private @NonNull Double productPrice;
	    private String photoLink;
	    private Integer stock;
	
}
