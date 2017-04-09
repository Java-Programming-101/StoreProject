/*
 * Order.java
 */
package co.shinetech.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.*;

/**
 * Domain class to transfer Order objects between layers.
 * @author rodrigo
 * @since 16/03/2017
 */
@Entity
@Table(name="orders") // MySQL does not accept table called "order", it is reserved word
public class Order implements Domain<LongPK>{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date estimatedDelivery;
	private OrderStatus orderStatus;
	private PaymentMethod paymentMethod;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(foreignKey=@ForeignKey(name="FK_ORDER_CUSTOMER"))
	private Customer customer;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="order")
	private List<OrderItem> items;
	
	public Order() {
		super();
	}
		
	/**
	 * @param id
	 */
	public Order(LongPK id) {
		super();
		this.id = id.getValue();
	}

	/**
	 * Constructor with all fields.
	 * @param id
	 * @param date
	 * @param estimatedDelivery
	 * @param orderStatus
	 * @param paymentMethod
	 * @param customer
	 * @param items
	 */
	public Order(LongPK id, Date date, Date estimatedDelivery, OrderStatus orderStatus,
			PaymentMethod paymentMethod, Customer customer, List<OrderItem> items) {
		super();
		this.id = id.getValue();
		this.orderDate = date;
		this.estimatedDelivery = estimatedDelivery;
		this.orderStatus = orderStatus;
		this.paymentMethod = paymentMethod;
		this.customer = customer;
		this.items = items;
	}

	public LongPK getId() {
		return new LongPK(id);
	}

	public void setId(LongPK id) {
		this.id = id.getValue();
		
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getEstimatedDelivery() {
		return estimatedDelivery;
	}

	public void setEstimatedDelivery(Date estimatedDelivery) {
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

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the items
	 */
	public Stream<OrderItem> getItemsStream() {
		return items.stream();
	}

	/**
	 * @param items the items to set
	 */
	public void addItems(List<OrderItem> items) {
		this.items.addAll(items);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + new LongPK(id).hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return new LongPK(id).equals(obj);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", estimatedDelivery=" + estimatedDelivery + ", orderStatus="
				+ orderStatus + ", paymentMethod=" + paymentMethod + ", customer=" + customer + ", items=" + items
				+ "]";
	}
}