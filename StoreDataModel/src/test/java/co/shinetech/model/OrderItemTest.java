package co.shinetech.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

        Order order  = new Order( 4l, new Date(2017,05,10), new Date (2017,05,11), OrderStatus.PROCESSED,
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
}