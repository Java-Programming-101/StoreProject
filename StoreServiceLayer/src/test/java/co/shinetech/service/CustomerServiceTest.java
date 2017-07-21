/*
* CustomerServiceTest.java
*/
package co.shinetech.service;

import co.shinetech.model.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Integration tests service and backend layers.
 * Created by rodrigo on 6/17/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    @Before
    public void setup() {
        List<Customer> list = Arrays.asList(new Customer[]{new Customer.Builder(1L).withName("John White").create(),
                                                           new Customer.Builder(2L).withName("John White").create()});

        list.stream().forEach(customerService::create);
    }


    @Test
    public void createTest() throws Exception {
        Customer c = new Customer();
        c.setName("John Black");
        customerService.create(c);
    }

    @Test
    public void findByIdTest() throws Exception {
        assertEquals(customerService.findById("1").getName(),"John White");
    }


    @Test
    public void findAllTest() throws Exception {
        List<Customer> list = (List<Customer>) customerService.findAll();

        assertEquals(list.size(),2);
    }


    @After
    public void clean() {
    }
}