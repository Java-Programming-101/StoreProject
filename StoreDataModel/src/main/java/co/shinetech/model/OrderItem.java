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
public class OrderItem implements Domain<LongPK> {
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
	public OrderItem(LongPK id, BigDecimal price, int qty, Order order, Product product) {
		super();
		this.id = id.getValue();
		this.price = price;
		this.qty = qty;
		this.order = order;
		this.product = product;
	}

	public LongPK getId() {
		return new LongPK(id);
	}
	public void setId(LongPK id) {
		this.id = id.getValue();
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
	public int hashCode() {
		return new LongPK(id).hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return new LongPK(this.id).equals(other.id);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", price=" + price + ", qty=" + qty + ", order=" + order + ", product=" + product
				+ "]";
	}
}