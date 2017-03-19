package co.shinetech.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderTest {

	@Test
	public void test() {
		assertTrue(true);
	}
	
	@Test
	public void checkEquals() {
		Order o1 = new Order(new LongPK(1L));
		Order o2 = new Order(new LongPK(2L));
		
		assertFalse(o1.equals(o2));
	}
}