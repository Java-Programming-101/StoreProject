/*
 * Domain.java
 */
package co.shinetech.model;

/**
 * Interface for domain classes. 
 * @author rodrigo
 * @since 16/03/2017
 * @param <K>
 */
public interface Domain <K>{
	LongPK getId();
	void setId(LongPK id);
}
