package accessingdatajpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

// The Customer class is annotated with @Entity, indicating that it is a JPA entity.
// Because no @Table annotation exists, it is assumed that this entity is mapped to a table named Customer.
@Entity
public class Customer {
  
  // The Customer object’s id property is annotated with @Id so that JPA recognizes it as the object’s ID.
  // The id property is also annotated with @GeneratedValue to indicate that the ID should be generated automatically.
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  
  // These two properties, firstName and lastName, are left unannotated.
  // It is assumed that they are mapped to columns that share the same names as the properties themselves.
  private String firstName;
  private String lastName;
  
  
  // We do not use this constructor directly, so it is designated as protected.
  protected Customer() {}
  
  // This constructor is the constructor which we use to create instances of Customer to be saved to the database.
  public Customer(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  
  public Long getId() { return id; }
  
  public String getFirstName() { 
    return firstName; 
  }
  
  public String getLastName() { 
    return lastName; 
  }
  
  public String toString() {
    return String.format(
      "Customer[id=%d, firstName='%s', lastName='%s']", 
      id, firstName, lastName
    );
  }
  
}
