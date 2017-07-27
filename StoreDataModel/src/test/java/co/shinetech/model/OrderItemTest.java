package co.shinetech.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Marc on 2/05/2017.
 */
public class OrderItemTest {

    @Test
    public void testGetSetID (){
        OrderItem oi = new OrderItem();

        oi.setId(7L);

        assertEquals(7L, oi.getId().longValue());
    }

    @Test
    public void testGetSetQuantity(){
        OrderItem oi = new OrderItem();
        int qty = 3;

        oi.setQty(qty);

        assertEquals(qty, oi.getQty());
    }

    @Test
    public void testGetSetPrice(){
        OrderItem oi = new OrderItem();
        BigDecimal price = new BigDecimal(39.33);

        oi.setPrice(price);

        assertEquals(price, oi.getPrice());
    }

    @Test
    public void testGetSetOrder(){
        OrderItem oi = new OrderItem();

        List<OrderItem> orderItemList = new ArrayList<>();

        Order order  = new Order( 4l, LocalDate.of(2017, 05, 10), LocalDate.of(2017,05,11), OrderStatus.PROCESSED,
                PaymentMethod.CASH, new Customer(), orderItemList);


        oi.setOrder(order);

        assertEquals(order.toString(), oi.getOrder().toString());
    }

    @Test
    public void testGetSetProduct(){
        OrderItem oi = new OrderItem();

        Product product = new Product();
        product.setId(7L);

        oi.setProduct(product);

        assertEquals(product, oi.getProduct());

    }
    @Test
    public void testEquals (){
        OrderItem oi1 = new OrderItem();
        OrderItem oi2 = new OrderItem();
        Object obj = new Object();
        OrderItem nOi = null;

        oi1.setId(187692L);
        oi2.setId(187692L);

        assertTrue(oi1.equals(oi1));
        assertTrue(oi1.equals(oi2));
        assertFalse(oi1.equals(obj));
        assertFalse(oi1.equals(nOi));

    }
    @Test
    public void testHashcode(){
        OrderItem oi1 = new OrderItem();
        oi1.setId(187692L);
        int hash = 187692;
        assertTrue(oi1.hashCode() == hash);

    }
}