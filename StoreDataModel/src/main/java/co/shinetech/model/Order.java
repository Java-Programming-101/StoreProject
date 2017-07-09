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
public class Order implements Domain<Long>{
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
	public Order(Long id) {
		super();
		this.id = id;
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
	public Order(long id, Date date, Date estimatedDelivery, OrderStatus orderStatus,
			PaymentMethod paymentMethod, Customer customer, List<OrderItem> items) {
		super();
		this.id = id;
		this.orderDate = date;
		this.estimatedDelivery = estimatedDelivery;
		this.orderStatus = orderStatus;
		this.paymentMethod = paymentMethod;
		this.customer = customer;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
		
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Order order = (Order) o;

		return id == order.id;
	}

	@Override
	public int hashCode() {
		return (int) (id ^ (id >>> 32));
	}

	/* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", estimatedDelivery=" + estimatedDelivery + ", orderStatus="
				+ orderStatus + ", paymentMethod=" + paymentMethod + ", customer=" + customer.getName() + ", items=" + items
				+ "]";
	}
}