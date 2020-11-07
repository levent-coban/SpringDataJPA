package accessingdatajpa;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


/*
 * A repository interface that works with Customer entities.
 *
 * Spring Data JPA focuses on using JPA to store data in a relational database.
 * Its most compelling feature is the ability to create repository implementationsautomatically, at runtime,
 * from a repository interface.
 *
 */


public interface CustomerRepository extends CrudRepository<Customer, Long> {
  
  // We Create here Simple Queries
  List<Customer> findByLastName(String lastName);
  Customer findById(long id);
  
}


/*
 * CustomerRepository extends the CrudRepository interface. The type of entity and ID that it works with, Customer
 * and Long, are specified in the generic parameters on CrudRepository.
 * By extending CrudRepository, CustomerRepository inherits several methods for working with Customer persistence,
 * including methods for saving, deleting, and finding Customer entities.
 *
 * Spring Data JPA also lets us define other query methods by declaring their method signature.
 * For example, CustomerRepository includes the findByLastName() method.
 *
 * In a typical Java application, a programmer might expect to write a class that implements CustomerRepository.
 * However, that is what makes Spring Data JPA so powerful:
 * We need not write an implementation of the repository interface.
 * Spring Data JPA creates an implementation when you run the application.
 *
 */

