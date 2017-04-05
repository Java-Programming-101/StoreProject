package co.shinetech.model;

import static org.junit.Assert.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class OrderTest {

	@Test
	public void testSetAndGetId() {
		long id = 1;
		LongPK pk = new LongPK(id);
		Order order = new Order();
		
		order.setId(pk);
		
		assertEquals(id, order.getId().getId());
	}
	
	@Test
	public void testSetAndGetDate() {
		ZoneId zoneId = ZoneId.of("NZ");
		ZonedDateTime date = ZonedDateTime.of(2017, 04, 01, 12, 30, 00, 0, zoneId);
		String dateAsString = date.toString();
		Order order = new Order();
		
		order.setDate(date);
		
		assertEquals(dateAsString, order.getDate().toString());
	}
	
	@Test
	public void testSetAndGetEstimatedDeliveryDate() {
		ZoneId zoneId = ZoneId.of("NZ");
		ZonedDateTime deliveryDate = ZonedDateTime.of(2017, 04, 05, 12, 30, 00, 0, zoneId);
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
	
	//TODO think about more suitable test
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
}