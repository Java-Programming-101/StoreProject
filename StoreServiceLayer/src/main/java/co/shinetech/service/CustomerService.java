/*
* CustomerService.java
*/
package co.shinetech.service;

import co.shinetech.model.Customer;
import co.shinetech.repository.CustomerRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Customer Service (CRUD).
 * Created by rodrigo on 4/7/2017.
 *
 * @RestController is Spring 4 annotation to transform the class in a REST controller, that will receive and response domain objects in HTTP body using JSON representation
 *                 marshalling and unmarshalling data between view and service layers.
 * @RequestParam does the mapping between HTTP query string parameters and a method parameter
 * @RequestBody get parameters passed in HTTP body
 * @ResponseBody send parameters through HTTP body
 */
@RestController
@RequestMapping(value="customer")
public class CustomerService implements Service<Customer>{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @RequestMapping(value="/create",method=RequestMethod.POST)
    @JsonIgnoreProperties({"orders"})
    public void create(@RequestBody Customer o) {
        customerRepository.save(o);
    }

    @Override
    @RequestMapping(value="/findById",method=RequestMethod.GET)
    @JsonIgnoreProperties({"orders"})
    public @ResponseBody Customer findById(@RequestParam String id) {
        return customerRepository.findOne(Long.valueOf(id));
    }

    @Override
    @RequestMapping(value="/findAll",method=RequestMethod.GET)
    @JsonIgnoreProperties({"orders"})
    public @ResponseBody Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    @JsonIgnoreProperties({"orders"})
    @RequestMapping(value="/update",method=RequestMethod.PUT)
    public void update(@RequestBody Customer o) {
        customerRepository.save(o);
    }

    @Override
    @JsonIgnoreProperties({"orders"})
    @RequestMapping(value="/delete",method=RequestMethod.DELETE)
    public void delete(@RequestBody Customer o) {
        customerRepository.delete(o);
    }
}