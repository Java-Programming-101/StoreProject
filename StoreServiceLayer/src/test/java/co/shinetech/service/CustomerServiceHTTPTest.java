/*
* CustomerServiceHTTPTest.java
*/
package co.shinetech.service;

import co.shinetech.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Mocked tests only for service layer without backend (database)
 * Warranty nobody will change the service interface.
 * Created by rodrigo on 6/18/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerService.class, secure = false)
public class CustomerServiceHTTPTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerService customerService;

    private ObjectMapper mapper = new ObjectMapper();

    private Customer mockCustomer = new Customer("John Mock");

    private Iterable<Customer> mockIterableCustomer = Arrays.asList(new Customer[] {new Customer("John White"),
                                                                                    new Customer( "John Red"),
                                                                                    new Customer( "John Blue")});

    @Before
    public void setup() {
    }


    @Test
    public void createTest() throws Exception {
        Customer c = new Customer("John Black");
        doNothing().when( customerService ).create( c );
        mockMvc.perform( post("/customer/create")
                         .contentType(MediaType.APPLICATION_JSON)
                         .content(mapper.writeValueAsString(c)));
    }

    @Test
    public void findByIdTest() throws Exception {
        Mockito.when( customerService.findById(Mockito.anyString()) ).thenReturn(mockCustomer);

        this.mockMvc.perform(get("/customer/findById/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.name", is("John Mock")));
    }


    @Test
    public void findAllTest() throws Exception {
        Mockito.when( customerService.findAll() ).thenReturn(mockIterableCustomer);
        this.mockMvc.perform( get("/customer/findAll").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$",hasSize(3) ))
                .andExpect(jsonPath( "$[0].name",is("John White")));
    }

    @After
    public void clean() {
    }
}
