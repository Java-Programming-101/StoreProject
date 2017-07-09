/*
 * Customer.java
 */
package co.shinetech.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/** 
 * Domain class to transfer Customer data between layers.
 * @author rodrigo
 * @since 16/03/2017
 */
@Data
@Entity
@Table
public class Customer implements Domain<Long>{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(length=50)
	private String name;
	private String address;
	@Column(length=20)
	private String zipcode;
	@Column(length=2)
	private String country;
	@Column(length=25)
	private String taxid;
	@Column(length=20)
	private String phone;
	private String email;
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="customer")
	private List<Order> orders = new ArrayList<>();

	public Customer() {
	}

	public Customer(Long id) {
		this.id = id;
	}

	public Customer(String name) {
		this.name = name;
	}

	/**
	 * Constructor with fields.
	 * @param id
	 * @param name
	 * @param address
	 * @param zipcode
	 * @param country
	 * @param taxid
	 * @param phone
	 * @param email
	 * @param birthDate
	 * @param orders
	 */
	public Customer(Long id, String name, String address, String zipcode, String country, String taxid, String phone, String email, Date birthDate, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;
		this.country = country;
		this.taxid = taxid;
		this.phone = phone;
		this.email = email;
		this.birthDate = birthDate;
		this.orders = orders;
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