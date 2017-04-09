/*
* PersistenceException.java
*/
package co.shinetech.exception;

/**
 * Class to transfer application exceptions between layers.
 * Created by rodrigo on 3/25/2017.
 */
public class PersistenceException extends Exception {
    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}