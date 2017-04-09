/*
 * Domain.java
 */
package co.shinetech.model;

import java.io.Serializable;

/**
 * Interface for domain classes. 
 * @author rodrigo
 * @since 16/03/2017
 * @param <K>
 */
public interface Domain<K> extends Serializable {
	K getId();
	void setId(K id);
}
