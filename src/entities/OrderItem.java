package entities;

public class OrderItem {

	private Integer quantity;
	private Double price;
	private Product product;

	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}
	
	public double subtotal() {
		return (double)quantity * price;		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(product);
		sb.append(", Quantity: " + quantity + ", Subtotal: $" + String.format("%.2f", subtotal()));
		
		return sb.toString();
	}
	
}
