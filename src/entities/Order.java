package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> orderItem = new ArrayList<>();
	
	public Order(OrderStatus status, Client client) {
		this.moment = new Date();
		this.status = status;
		this.client = client;
	}
	
	public void addItem (OrderItem item) {
		orderItem.add(item);
		
	}
	
	public void removeItem (OrderItem item) {
		orderItem.remove(item);
	}
	
	public double total() {
		double soma = 0;
		for (OrderItem order : orderItem) {
			soma += order.subtotal();
		}
		return soma;
	}
		
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order Status: ");
		sb.append(status + "\n");
		sb.append("Client: " + client + "\n");
		
		for (OrderItem order : orderItem) {
			sb.append(order + "\n");
		}
		
		sb.append("Total Price: " + String.format("%.2f", total()));
		
		return sb.toString();
	}
	
}


