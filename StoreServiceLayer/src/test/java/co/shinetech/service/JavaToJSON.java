/*
* JavaToJSON.java
*/
package co.shinetech.service;

import co.shinetech.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by rodrigo on 4/24/2017.
 */
public class JavaToJSON {
    @Test
    public void createCustomer() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Customer c = new Customer(2L);
        c.setName("Customer #1");
        c.setAddress("Theodore St, 99");
        c.setCountry("GB");
        c.setBirthDate(Calendar.getInstance().getTime());
        c.setEmail("customer@myplace.co");
        c.setTaxid("000.214.979-66");
        c.setZipcode("88000-000");
        mapper.writeValue(new File("./Customer2.json"),c);
    }
}
