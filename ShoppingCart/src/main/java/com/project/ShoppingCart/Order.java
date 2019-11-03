package com.project.ShoppingCart;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "orders")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Order {
	
   	@Id
    private String _id;
	private @NonNull Product product;
	private @NonNull Integer quantity;
	private String status;
}
