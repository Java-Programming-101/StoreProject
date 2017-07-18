/*
 * Product.java
 */
package co.shinetech.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Domain class to transport Product object between layers.
 * @author rodrigo
 * @since 16/03/2017
 */
@Entity
@Table
public class Product implements Domain<Long>{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private BigDecimal price;
	private int weight;
	@Column(length=40)
	private String barcode;
	private int dimX;
	private int dimY;
	private int dimZ;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="product")
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	@ManyToOne
	Category category;

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
	public Product(long id, String name, BigDecimal price, int weight, String barcode, int dimX, int dimY, int dimZ,
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
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Product product = (Product) o;

		return id == product.id;
	}

	@Override
	public int hashCode() {
		return (int) (id ^ (id >>> 32));
	}
}