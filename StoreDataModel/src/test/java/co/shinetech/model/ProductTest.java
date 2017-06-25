package co.shinetech.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.Test;

public class ProductTest {
	private static Product product= new Product();

	@Test
	public void SetAndGet_id_test() {
		Long expectedId = new Long(1L);
		product.setId(expectedId);
		Long acutalId = product.getId();
		assertEquals("acutal productid is wrong",expectedId,acutalId);
	}
	
	@Test
	public void SetAndGet_name_test() {
		String expectName = "Pizza";
		product.setName(expectName);
		String acutalName =product.getName();
		assertEquals("acutal productName is wrong",expectName,acutalName);
	}
	
	@Test
	public void SetAndGet_price_test() {
		BigDecimal expectedPrice = new BigDecimal("25");
		product.setPrice(expectedPrice);
		BigDecimal acutalPrice = product.getPrice();
		assertEquals("acutal productPrice is wrong",expectedPrice,acutalPrice);
	}
	
	@Test
	public void SetAndGet_weight_test() {
		int expectedWeight = 1;
		product.setWeight(expectedWeight);
		int acutalWeigth= product.getWeight();
		assertEquals("acutal productWeight is wrong",expectedWeight,acutalWeigth);
	}
	
	@Test
	public void SetAndGet_barcode_test() {
		String expectedBarcode = "23234sfsf";
		product.setBarcode(expectedBarcode);
		String acutalBarcode= product.getBarcode();
		assertEquals("acutal productBarcode is wrong",expectedBarcode,acutalBarcode);
	}
	
	@Test
	public void SetAndGet_dimX_test() {
		int expectedDimX = 1;
		product.setDimX(expectedDimX);
		int acutalDimx = product.getDimX();
		assertEquals("acutal productDimx is wrong",expectedDimX,acutalDimx);
	}
	
	@Test
	public void SetAndGet_dimY_test() {
		int expectedDimY = 2;
		product.setDimY(expectedDimY);
		int acutalDimY = product.getDimY();
		assertEquals("acutal productDimY is wrong",expectedDimY,acutalDimY);
	}
	
	@Test
	public void SetAndGet_dimZ_test() {
		int expectedDimZ = 3;
		product.setDimZ(expectedDimZ);
		int acutalDimZ = product.getDimZ();
		assertEquals("acutal productDimZ is wrong",expectedDimZ,acutalDimZ);
	}
	
	@Test
	public void SetAndGet_OrderItems_test() {
		boolean isOk = true;
		
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		Long id = new Long(1L);
		BigDecimal price = new BigDecimal("50");
		int qty = 2;
		Order order = new Order(id);
		OrderItem orderItem = new OrderItem(id, price, qty, order, product);
		orderItems.add(orderItem);
		
		product.addOrderItems(orderItems);
		Stream<OrderItem> acutalOrderItems= product.getOrderItemsStream();
		Object[] actual = acutalOrderItems.toArray();
		Object[] expected = orderItems.stream().toArray();
		for(int i =0; i<actual.length;i++ ){
			if(!actual[i].equals(expected[i])){
				isOk = false;
			}
		}
		assertTrue("acutal productOrderItems is wrong",isOk);
	}
}