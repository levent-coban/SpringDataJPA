package accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
 * @SpringBootApplication is a convenience annotation that adds all of the following:
 *
 * - @Configuration: Tags the class as a source of bean definitions for the application context.
 *
 * - @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans,
 *   and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the
 *   application as a web application and activates key behaviors, such as setting up a DispatcherServlet.
 *
 * - @ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package,
 *   letting it find the controllers.
 *
 *
 * The main() method uses Spring Boot’s SpringApplication.run() method to launch an application.
 * Notice that there was not a single line of XML? There is no web.xml file, either.
 * This web application is 100% pure Java and we did not have to deal with configuring any plumbing or infrastructure.
 *
 */

@SpringBootApplication
public class Application {
	
	// To get output (to the console, in this example), we need to set up a logger.
	// Then we need to set up some data and use it to generate output.
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));
			
			log.info("");
			log.info("");
			
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			
			log.info("");
			log.info("");
			
			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			
			log.info("");
			log.info("");
			
			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
		};
	}
	
}
/*
 * The Application class includes a demo() method that puts the CustomerRepository through a few tests.
 * First, it fetches the CustomerRepository from the Spring application context.
 * Then it saves a handful of Customer objects, demonstrating the save() method and setting up some data to work with.
 * Next, it calls findAll() to fetch all Customer objects from the database.
 * Then it calls findById() to fetch a single Customer by its ID.
 * Finally, it calls findByLastName() to find all customers whose last name is "Bauer".
 * The demo() method returns a CommandLineRunner bean that automatically runs the code when the application launches.
 *
 *
 * By default, Spring Boot enables JPA repository support and looks in the package (and its subpackages)
 * where @SpringBootApplication is located. If your configuration has JPA repository interface definitions
 * located in a package that is not visible, you can point out alternate packages by using @EnableJpaRepositories
 * and its type-safe basePackageClasses=MyRepository.class parameter.
 *
 */
