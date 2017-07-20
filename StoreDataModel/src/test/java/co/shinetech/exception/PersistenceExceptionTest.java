/*
* PersistenceExceptionTest.java
*/
package co.shinetech.exception;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by rodrigo on 7/21/2017.
 */
public class PersistenceExceptionTest {
    @Test(expected = PersistenceException.class)
    public void testPersistenceCreation() throws PersistenceException {
        throw new PersistenceException("Message",new IllegalArgumentException("Error"));
    }

    @Test
    public void testPersistenceInstance() {
        PersistenceException pe = new PersistenceException("Message",new IllegalArgumentException("Error"));
        assertEquals(pe.getMessage(),"Message");
        assertTrue(pe.getCause() instanceof IllegalArgumentException);
    }
}
