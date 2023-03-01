package app.huanying.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderItems {

	@Id
	private Long orderItemId;
	private int quantity;
	private String specialRequests;
	
	

	public OrderItems() {
	}

	public OrderItems(Long orderItemId, int quantity, String specialRequests) {
		super();
		this.orderItemId = orderItemId;
		this.quantity = quantity;
		this.specialRequests = specialRequests;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSpecialRequests() {
		return specialRequests;
	}

	public void setSpecialRequests(String specialRequests) {
		this.specialRequests = specialRequests;
	}

	@Override
	public String toString() {
		return String.format("OrderItems [orderItemId=%s, quantity=%s, specialRequests=%s]", orderItemId, quantity,
				specialRequests);
	}

}
