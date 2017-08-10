package co.shinetech.model;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 * Created by Marc on 09/08/2017.
 */
public class SpecialOfferTest {
    @Test
    public void testGetSetOfferStartDate() throws Exception {
        SpecialOffer specialOffer = new SpecialOffer();
        LocalDateTime dateTime = LocalDateTime.now();

        specialOffer.setOfferStartDate(dateTime);

        assertTrue(dateTime.equals(specialOffer.getOfferStartDate()));
    }

    @Test
    public void testGetSetOfferEndDate() throws Exception {
        SpecialOffer specialOffer = new SpecialOffer();
        LocalDateTime dateTime = LocalDateTime.now();

        specialOffer.setOfferEndDate(dateTime);

        assertTrue(dateTime.equals(specialOffer.getOfferEndDate()));

    }

    @Test
    public void testGetSetFixedPriceAmountOff() throws Exception {
        SpecialOffer specialOffer = new SpecialOffer();
        BigDecimal priceoff = new BigDecimal(19.99).setScale(2, RoundingMode.CEILING);

        specialOffer.setFixedPriceAmountOff(priceoff);

        assertEquals(priceoff, specialOffer.getFixedPriceAmountOff());

    }

    @Test
    public void testGetSetPercentageOff() throws Exception {
        SpecialOffer specialOffer = new SpecialOffer();
        float percentOff = 25.00f;

        specialOffer.setPercentageOff(percentOff);

        assertTrue(percentOff == specialOffer.getPercentageOff());
    }

    @Test
    public void testGetSetProductOnOffer() throws Exception {
        SpecialOffer specialOffer = new SpecialOffer();
        Product product = new Product();
        product.setId(265L);
        product.setName("Lacoste Jumper");

        specialOffer.setProductOnOffer(product);

        assertTrue(product.equals(specialOffer.getProductOnOffer()));

    }

    @Test
    public void testGetSetCategoryOnOffer() throws Exception {
        SpecialOffer specialOffer = new SpecialOffer();
        Category category = new Category();
        category.setId(768376L);
        category.setName("Shoes");

        specialOffer.setCategoryOnOffer(category);

        assertTrue(category.equals(specialOffer.getCategoryOnOffer()));
    }

    @Test
    public void testEquals() throws Exception {
        SpecialOffer specialOffer = new SpecialOffer();
        specialOffer.setId(786287L);

        SpecialOffer specialOffer2 = new SpecialOffer();
        specialOffer2.setId(786287L);

        SpecialOffer nullOffer = null;

        Object obj = new Object();

        assertTrue(specialOffer.equals(specialOffer));
        assertTrue(specialOffer.equals(specialOffer2));
        assertFalse(specialOffer.equals(nullOffer));
        assertFalse(specialOffer.equals(null));
        assertFalse(specialOffer.equals(obj));
    }

    @Test
    public void testHashCode() throws Exception {
        Long id = 876283L;

        SpecialOffer specialOffer = new SpecialOffer();
        specialOffer.setId(id);

        assertTrue(id == specialOffer.hashCode());

    }

    @Test
    public void testToString() throws Exception {
        Product product = new Product();
        product.setId(87672L);

        SpecialOffer specialOffer = new SpecialOffer();
        specialOffer.setId(9876L);
        specialOffer.setCategoryOnOffer(new Category(8762L));
        specialOffer.setPercentageOff(25f);
        specialOffer.setProductOnOffer(product);
        specialOffer.setOfferStartDate(LocalDateTime.MIN);
        specialOffer.setOfferEndDate(LocalDateTime.MAX);
        specialOffer.setFixedPriceAmountOff(new BigDecimal(87.23));

        String Expected ="SpecialOffer{id=9876, offerStartDate=-999999999-01-01T00:00, offerEndDate=+999999999-12-31T23:59:59.999999999, fixedPriceAmountOff=87.24, percentageOff=25.0, productOnOffer=Product{id=87672, name='null', price=null, weight=0, barcode='null', dimX=0, dimY=0, dimZ=0, image='null', orderItems=[], category=null}, categoryOnOffer=Category{id=8762, name='null', description='null', image=null, parent=null, children=null}}";

        assert (specialOffer.toString().equals(Expected));

    }

}