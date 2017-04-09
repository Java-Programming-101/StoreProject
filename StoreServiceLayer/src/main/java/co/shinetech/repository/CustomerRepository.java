/*
* CustomerRepository.java
*/
package co.shinetech.repository;

import co.shinetech.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rodrigo on 4/9/2017.
 */
public interface CustomerRepository extends CrudRepository<Customer,Long>{
}