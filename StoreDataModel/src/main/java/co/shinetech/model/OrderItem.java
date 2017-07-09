/*
 * OrderItem.java
 */
package co.shinetech.model;

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

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
 	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		OrderItem orderItem = (OrderItem) o;

		return id == orderItem.id;
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
		return "OrderItem [id=" + id + ", price=" + price + ", qty=" + qty + ", order items total =" + order.getItemsStream().toArray().length + ", product=" + product
				+ "]";
	}
}