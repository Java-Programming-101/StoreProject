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
public interface Domain<K>{
	K getId();
	void setId(K id);
}
