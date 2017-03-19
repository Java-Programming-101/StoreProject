/*
 * Product.java
 */
package co.shinetech.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Domain class to transport Product object between layers.
 * @author rodrigo
 * @since 16/03/2017
 */
@Entity
@Table
public class Product implements Domain<LongPK>{
	@EmbeddedId
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private LongPK id;
	private String name;
	private BigDecimal price;
	private int weight;
	private String barcode;
	private int dimX;
	private int dimY;
	private int dimZ;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="product")
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	public Product() {
		super();
	}
	
	/**
	 * Constructor with fields.
	 * @param id
	 * @param name
	 * @param price
	 * @param weight
	 * @param barcode
	 * @param dimX
	 * @param dimY
	 * @param dimZ
	 * @param orderItems
	 */
	public Product(LongPK id, String name, BigDecimal price, int weight, String barcode, int dimX, int dimY, int dimZ,
			List<OrderItem> orderItems) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.barcode = barcode;
		this.dimX = dimX;
		this.dimY = dimY;
		this.dimZ = dimZ;
		this.orderItems = orderItems;
	}

	@Override
	public LongPK getId() {
		return id;
	}
	@Override
	public void setId(LongPK id) {
		this.id = id;
	}
	public int getDimX() {
		return dimX;
	}
	public void setDimX(int dimX) {
		if( dimX >= 0 ) {
			this.dimX = dimX;
		}
	}
	public int getDimY() {
		return dimY;
	}
	public void setDimY(int dimY) {
		this.dimY = dimY;
	}
	public int getDimZ() {
		return dimZ;
	}
	public void setDimZ(int dimZ) {
		this.dimZ = dimZ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/**
	 * @return the orderItems
	 */
	public Stream<OrderItem> getOrderItemsStream() {
		return orderItems.stream();
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void addOrderItems(List<OrderItem> orderItems) {
		this.orderItems.addAll(orderItems);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}