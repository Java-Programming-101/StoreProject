/**
 * JPAGenerator.java
 */
package co.shinetech.model.tool;

import javax.persistence.Persistence;

/**
 * @author rodrigo
 * @since 17/03/2017
 */
public class JPAGenerator {
	public static void main(String[] args) {
		Persistence.generateSchema("storePU", null);
	}
}