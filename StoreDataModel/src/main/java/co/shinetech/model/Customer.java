/*
 * Customer.java
 */
package co.shinetech.model;

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
		super();
	}

	public Customer(Long id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTaxid() {
		return taxid;
	}

	public void setTaxid(String taxid) {
		this.taxid = taxid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void addOrders(List<Order> orders) {
		this.orders.addAll(orders);
	}

	public Stream<Order> getOrdersStream() {
		return orders.stream();
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
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", zipcode=" + zipcode + ", country="
				+ country + ", taxid=" + taxid + ", phone=" + phone + ", email=" + email + ", birthDate=" + birthDate
				+ ", orders=" + orders + "]";
	}
}