package co.shinetech.model;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

import org.junit.Test;

public class OrderTest {

	@Test
	public void testSetAndGetId() {
		long id = 1;
		Long pk = new Long(id);
		Order order = new Order();
		
		order.setId(pk);
		
		assertEquals(id, order.getId().longValue());
	}
	
	@Test
	public void testSetAndGetDate() {
		LocalDate d = LocalDate.of(2010,1,6);
		String dateAsString = d.toString();

		Order order = new Order();
		order.setOrderDate(d);
		
		assertEquals(dateAsString, order.getOrderDate().toString());
	}
	
	@Test
	public void testSetAndGetEstimatedDeliveryDate() {

		LocalDate deliveryDate = LocalDate.now().plusWeeks(2);
		String deliveryDateAsString = deliveryDate.toString();
		Order order = new Order();
		
		order.setEstimatedDelivery(deliveryDate);
		
		assertEquals(deliveryDateAsString, order.getEstimatedDelivery().toString());
	}
	
	@Test
	public void testSetAndGetOrderStatus() {
		OrderStatus orderStatus = OrderStatus.CART;
		Order order = new Order();
		
		order.setOrderStatus(orderStatus);
		
		assertEquals(orderStatus, order.getOrderStatus());
	}
	
	@Test
	public void testSetAndGetPaymentMethod() {
		PaymentMethod paymentMethod = PaymentMethod.CASH;
		Order order = new Order();
		
		order.setPaymentMethod(paymentMethod);
		
		assertEquals(paymentMethod, order.getPaymentMethod());
	}
	
	@Test
	public void testSetAndGetCustomer() {
		Customer customer = new Customer();
		Order order = new Order();
		
		order.setCustomer(customer);
		
		assertEquals(customer, order.getCustomer());
	}

	@Test
	public void testAddAndGetItems() {
		OrderItem item1 = new OrderItem();
		OrderItem item2 = new OrderItem();
		List<OrderItem> listToAdd = new ArrayList();
		listToAdd.add(item1);
		listToAdd.add(item2);
		Order order = new Order();
		
		order.addItems(listToAdd);
		
		Object[] arrayToGet = order.getItemsStream().toArray();
		
		assertEquals(item1, arrayToGet[0]);
		assertEquals(item2, arrayToGet[1]);
	}

	@Test
	public void testEquals() {
		OrderItem item1 = new OrderItem();
		OrderItem item2 = new OrderItem();
		List<OrderItem> listToAdd = new ArrayList();
		listToAdd.add(item1);
		listToAdd.add(item2);
		Order order1 = new Order();
		Order order2 = new Order();

		order1.addItems(listToAdd);
		order2.addItems(listToAdd);

		Object emptyObj = new Object();


		assertTrue(order1.equals(order2));
		assertFalse(order1.equals(emptyObj));
		assertFalse(order1.equals(null));
	}

	@Test
	public void testHashCode(){
		OrderItem item1 = new OrderItem();
		OrderItem item2 = new OrderItem();
		List<OrderItem> listToAdd = new ArrayList();
		listToAdd.add(item1);
		listToAdd.add(item2);
		Order order1 = new Order();
		order1.setId(677398L);
		assertTrue(order1.hashCode() == 677398);
	}
}