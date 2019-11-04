package com.project.ShoppingCart;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "submittedOrders")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class SubmittedOrder {
	@Id
	private String _id;
	private List<Order> orders;
	private Double total;

}
