/*
 * LongPK.java
 */
package co.shinetech.model;

import javax.persistence.Embeddable;

/**
 * Key class for long ids. 
 * @author rodrigo
 * @since 16/03/2017
 */
@Embeddable
public class LongPK implements PK {
	private long id;
	
	/**
	 * Constructor with fields.
	 * @param id
	 */
	public LongPK(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LongPK other = (LongPK) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LongPK [id=" + id + "]";
	}	
}