/*
 * Order.java
 */
package co.shinetech.model;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.*;

/**
 * Domain class to transfer Order objects between layers.
 * @author rodrigo
 * @since 16/03/2017
 */
@Data
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

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}
}