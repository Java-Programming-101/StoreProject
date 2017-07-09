/*
 * Product.java
 */
package co.shinetech.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.*;

/**
 * Domain class to transport Product object between layers.
 * @author rodrigo
 * @since 16/03/2017
 */
@Data
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
}