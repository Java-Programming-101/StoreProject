package co.shinetech.repository;

import co.shinetech.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rodrigo on 6/26/2017.
 */
public interface ProductRepository extends CrudRepository<Product,Long> {
}