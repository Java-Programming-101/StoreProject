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
	private Long id;
	@Column(length=50)
	private String name;
	@Column(length = 128)
	private String address;
	@Column(length=20)
	private String zipCode;
	@Column(length=2)
	private String country;
	@Column(length=25)
	private String taxId;
	@Column(length=20)
	private String phone;
	@Column(length = 128)
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
	 * @param zipCode
	 * @param country
	 * @param taxId
	 * @param phone
	 * @param email
	 * @param birthDate
	 * @param orders
	 */
	public Customer(Long id, String name, String address, String zipCode, String country, String taxId, String phone, String email, Date birthDate, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.zipCode = zipCode;
		this.country = country;
		this.taxId = taxId;
		this.phone = phone;
		this.email = email;
		this.birthDate = birthDate;
		this.orders = orders;
	}

	public static class Builder {
		private long nestedId;
		private String nestedName;
		private String nestedAddress;
		private String nestedZipCode;
		private String nestedCountry;
		private String nestedTaxId;
		private String nestedPhone;
		private String nestedEmail;
		private Date nestedBirthDate;
		private List<Order> nestedOrders = new ArrayList<>();

		public Builder(long id) {
			this.nestedId = id;
		}

		public Builder withName(String name) {
			this.nestedName = name;
			return this;
		}

		public Builder withAddress(String address) {
			this.nestedAddress = address;
			return this;
		}

		public Builder withZipCode(String zipCode) {
			this.nestedZipCode = zipCode;
			return this;
		}

		public Builder withCountry(String country) {
			this.nestedCountry = country;
			return this;
		}

		public Builder withTaxId(String taxId) {
			this.nestedTaxId = taxId;
			return this;
		}

		public Builder withPhone(String phone) {
			this.nestedPhone = phone;
			return this;
		}

		public Builder withEmail(String email) {
			this.nestedEmail = email;
			return this;
		}

		public Builder withBirthDate(Date birthDate) {
			this.nestedBirthDate = birthDate;
			return this;
		}

		public Customer create() {
			return new Customer(nestedId, nestedName, nestedAddress, nestedZipCode, nestedCountry, nestedTaxId, nestedPhone, nestedEmail, nestedBirthDate, nestedOrders);
		}
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
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
		return "Customer [nestedId=" + id + ", nestedName=" + name + ", nestedAddress=" + address + ", nestedZipCode=" + zipCode + ", nestedCountry="
				+ country + ", nestedTaxId=" + taxId + ", nestedPhone=" + phone + ", nestedEmail=" + email + ", nestedBirthDate=" + birthDate
				+ ", nestedOrders=" + orders + "]";
	}
}