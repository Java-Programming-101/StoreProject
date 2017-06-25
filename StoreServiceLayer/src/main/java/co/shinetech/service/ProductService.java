/*
* ProductService.java
*/
package co.shinetech.service;

import co.shinetech.model.Product;
import co.shinetech.repository.ProductRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by rodrigo on 6/26/2017.
 */
@RestController
@RequestMapping(value="product")
public class ProductService implements Service<Product> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    @RequestMapping(value="/create",method= RequestMethod.POST)
    @JsonIgnoreProperties({"orders"})
    public void create(@RequestBody Product o) {
        productRepository.save(o);
    }

    @Override
    @RequestMapping(value="/findById/{id}",method=RequestMethod.GET)
    @JsonIgnoreProperties({"orders"})
    public @ResponseBody
    Product findById(@PathVariable String id) {
        return productRepository.findOne(Long.valueOf(id));
    }

    @Override
    @RequestMapping(value="/findAll",method=RequestMethod.GET)
    @JsonIgnoreProperties({"orders"})
    public @ResponseBody Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @JsonIgnoreProperties({"orders"})
    @RequestMapping(value="/update",method=RequestMethod.PUT)
    public void update(@RequestBody Product o) {
        productRepository.save(o);
    }

    @Override
    @JsonIgnoreProperties({"orders"})
    @RequestMapping(value="/delete",method=RequestMethod.DELETE)
    public void delete(@RequestBody Product o) {
        productRepository.delete(o);
    }
}
