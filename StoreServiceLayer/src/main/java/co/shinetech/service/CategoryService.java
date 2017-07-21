/*
* CustomerService.java
*/
package co.shinetech.service;

import co.shinetech.model.Category;
import co.shinetech.repository.CategoryRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Category Service (CRUD).
 * Created by rodrigo on 3/7/2017.
 *
 * @RestController is Spring 4 annotation to transform the class in a REST controller, that will receive and response domain objects in HTTP body using JSON representation
 *                 marshalling and unmarshalling data between view and service layers.
 * @RequestParam does the mapping between HTTP query string parameters and a method parameter
 * @RequestBody get parameters passed in HTTP body
 * @ResponseBody send parameters through HTTP body
 */
@RestController
@RequestMapping(value="category")
public class CategoryService implements Service<Category>{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @RequestMapping(value="/create",method=RequestMethod.POST)
    @JsonIgnoreProperties({"orders"})
    public void create(@RequestBody Category o) {
        categoryRepository.save(o);
    }

    @Override
    @RequestMapping(value="/findById/{id}",method=RequestMethod.GET)
    public @ResponseBody Category findById(@PathVariable String id) {
        return categoryRepository.findOne(Long.valueOf(id));
    }

    @Override
    @RequestMapping(value="/findAll",method=RequestMethod.GET)
    public @ResponseBody Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value="/findFirstLevel",method=RequestMethod.GET)
    @JsonIgnoreProperties({"parent","children"})
    public @ResponseBody Iterable<Category> findFirstLevel() {
        return categoryRepository.findFirstLevel();
    }

    @CrossOrigin
    @RequestMapping(value="/findSecondLevel/{id}",method=RequestMethod.GET)
    @JsonIgnoreProperties({"parent","children"})
    public @ResponseBody Iterable<Category> findSubCategories(@PathVariable String id) {
        return categoryRepository.findSubCategories(Long.valueOf(id));
    }

    @Override
    @RequestMapping(value="/update",method=RequestMethod.PUT)
    public void update(@RequestBody Category o) {
        categoryRepository.save(o);
    }

    @Override
    @RequestMapping(value="/delete",method=RequestMethod.DELETE)
    public void delete(@RequestBody Category o) {
        categoryRepository.delete(o);
    }
}