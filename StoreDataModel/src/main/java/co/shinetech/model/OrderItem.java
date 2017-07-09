/*
 * OrderItem.java
 */
package co.shinetech.model;

import lombok.Data;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Domain class to transport OrderItem objects between layers.
 * @author rodrigo
 * @since 16/03/2017
 */
@Data
@Entity
@Table
public class OrderItem implements Domain<Long> {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private BigDecimal price;
	private int qty;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(foreignKey=@ForeignKey(name="FK_ORDERITEM_ORDER"))
	private Order order;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(foreignKey=@ForeignKey(name="FK_PRODUCT_ORDERITEM"))
	private Product product;
 
	public OrderItem() {
		super();
	}
	
	/**
	 * Constructor with fields.
	 * @param id
	 * @param price
	 * @param qty
	 * @param order
	 * @param product
	 */
	public OrderItem(Long id, BigDecimal price, int qty, Order order, Product product) {
		super();
		this.id = id;
		this.price = price;
		this.qty = qty;
		this.order = order;
		this.product = product;
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