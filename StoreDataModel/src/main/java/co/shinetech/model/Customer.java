/*
 * Customer.java
 */
package co.shinetech.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** 
 * Domain class to tranfer Customer data between layers.
 * @author rodrigo
 * @since 16/03/2017
 */
@Entity
@Table
public class Customer implements Domain<LongPK>{
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
	private LocalDate birthdate;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="customer")
	private List<Order> orders;

	public Customer() {
		super();
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
	 * @param birthdate
	 * @param orders
	 */
	public Customer(LongPK id, String name, String address, String zipcode, String country, String taxid, String phone, String email, LocalDate birthdate, List<Order> orders) {
		super();
		this.id = id.getValue();
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;
		this.country = country;
		this.taxid = taxid;
		this.phone = phone;
		this.email = email;
		this.birthdate = birthdate;
		this.orders = orders;
	}

	@Override
	public LongPK getId() {
		return new LongPK(id);
	}

	@Override
	public void setId(LongPK id) {
		this.id = id.getValue();
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

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
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
				+ country + ", taxid=" + taxid + ", phone=" + phone + ", email=" + email + ", birthdate=" + birthdate
				+ ", orders=" + orders + "]";
	}
}