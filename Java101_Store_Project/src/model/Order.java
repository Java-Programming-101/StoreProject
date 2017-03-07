package model;

import java.time.ZonedDateTime;

public class Order implements Domain<LongPK>{
	
	private  LongPK id;
	private ZonedDateTime date;
	private ZonedDateTime estimatedDelivery;
	private OrderStatus orderStatus;
	private PaymentMethod paymentMethod;
	
	
	@Override
	public LongPK getId() {
		return id;
	}

	@Override
	public void setId(LongPK id) {
		this.id = id;
		
	}

	public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}

	public ZonedDateTime getEstimatedDelivery() {
		return estimatedDelivery;
	}

	public void setEstimatedDelivery(ZonedDateTime estimatedDelivery) {
		this.estimatedDelivery = estimatedDelivery;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
			return id.equals(obj);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", estimatedDelivery=" + estimatedDelivery + ", orderStatus="
				+ orderStatus + ", paymentMethod=" + paymentMethod + "]";
	}
	

	
	


}
