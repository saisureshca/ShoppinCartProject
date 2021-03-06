package com.project.ShoppingCart;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	SubmittedOrderRepository submittedOrderRepository;

	@GetMapping("/api/getOrders")
	public List<Order> getOrders() {
		List<Order> list = orderRepository.findAll().stream()
				.filter(order -> order.getStatus().equalsIgnoreCase("PENDING")).collect(Collectors.toList());
		return list;
	}

	@GetMapping("/api/getTotal")
	public Double getTotal() {
		Double total = orderRepository.findAll().stream().filter(or -> or.getStatus().equalsIgnoreCase("PENDING"))
				.mapToDouble(p -> p.getQuantity() * p.getProduct().getProductPrice()).sum();
		DecimalFormat df = new DecimalFormat("#.##");
		total = Double.valueOf(df.format(total));
		return total;
	}

	@RequestMapping(value = "/api/addOrder", method = RequestMethod.POST)
	Order addOrder(@RequestBody Order order) {
		List<Order> checklist = orderRepository.findAll().stream()
				.filter(ord -> ord.getStatus().equalsIgnoreCase("PENDING")
						&& ord.getProduct().getProductName().equalsIgnoreCase(order.getProduct().getProductName()))
				.collect(Collectors.toList());
		if (checklist.size() > 0) {
			Order od = checklist.get(0);
			Integer quantity = od.getQuantity() + 1;
			od.setQuantity(quantity);
			return orderRepository.save(od);
		}
		return orderRepository.save(order);

	}

	@RequestMapping(value = "/api/removeOrder", method = RequestMethod.POST)
	Boolean removeOrder(@RequestBody Order order) {
		List<Order> checklist = orderRepository.findAll().stream()
				.filter(ord -> ord.getStatus().equalsIgnoreCase("PENDING")
						&& ord.getProduct().getProductName().equalsIgnoreCase(order.getProduct().getProductName()))
				.collect(Collectors.toList());
		if (checklist.size() > 0) {
			Order od = checklist.get(0);
			Integer quantity = od.getQuantity() - 1;
			od.setQuantity(quantity);
			if (quantity == 0) {
				orderRepository.delete(od);
				return false;
			}
			orderRepository.save(od);
			return false;
		} else
			return true;

	}

	@RequestMapping(value = "/api/deleteOrder", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	void deleteOrder(@RequestBody Order order) {
		orderRepository.delete(order);

	}

	@RequestMapping(value = "/api/deleteAlOrders", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	String deleteOrders() {
		List<Order> deleteList = orderRepository.findAll().stream()
				.filter(ord -> ord.getStatus().equalsIgnoreCase("PENDING")).collect(Collectors.toList());
		orderRepository.deleteAll(deleteList);
		return "Cart Cleared";
	}

	@RequestMapping(value = "/api/submitOrders", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	List<Order> submitOrders() {
		List<Order> submitList = orderRepository.findAll().stream()
				.filter(ord -> ord.getStatus().equalsIgnoreCase("PENDING")).collect(Collectors.toList());
		submitList.stream().forEach(order -> order.setStatus("COMPLETED"));
		List<Order> ordersSaved = orderRepository.saveAll(submitList);
		Double total = submitList.stream().filter(or -> or.getStatus().equalsIgnoreCase("PENDING"))
				.mapToDouble(p -> p.getQuantity() * p.getProduct().getProductPrice()).sum();
		DecimalFormat df = new DecimalFormat("#.##");
		total = Double.valueOf(df.format(total));
		SubmittedOrder submitted = new SubmittedOrder();
		submitted.setOrders(ordersSaved);
		submitted.setTotal(total);
		submittedOrderRepository.save(submitted);
		return ordersSaved;
	}
	
	@RequestMapping(value = "/api/finishedOrders", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	List<Order> finishedOrders() {
		List<Order> finishedOrders = new ArrayList<Order>();
		List<List<Order>> finished = submittedOrderRepository.findAll().stream().map(o->o.getOrders()).collect(Collectors.toList());
		finished.forEach(o->finishedOrders.addAll(o));
		return finishedOrders;
	}

}
