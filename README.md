# SpringDataJPA

An application that uses Spring Data JPA to store and retrieve data in a relational database.
<br/>

### Accessing Data (H2) with JPA

#####
Learning how to work with JPA data persistence using Spring Data JPA.

##### *
Spring Data JPA focuses on using JPA to store data in a relational database. 

Its most compelling feature is the ability to create repository implementations automatically, at runtime, from a repository interface.

##### *
In this application,

We store Customer objects, each annotated as a JPA entity. 

Customer class is a Simple Entity (in src/main/java/accessingdatajpa/Customer.java).
<br/>
<br/>
### Spring Initializr

start.spring.io

The Initializr offers a fast way to pull in all the dependencies you need for an application and does a lot of the set up for programmers. 

The Spring Initializr link for this application:

https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.3.5.RELEASE&packaging=jar&jvmVersion=1.8&groupId=&artifactId=artifact&name=&description=Spring%20-%20Accessing%20Data%20with%20JPA&packageName=accessingdatajpa&dependencies=data-jpa,h2 <br/>
<br/>

### This application needs the JPA and H2 dependencies:

### JPA:
The Java ORM standard for storing, accessing, and managing Java objects in a relational database.

Spring Data JPA (SQL)

Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.

### H2:
H2 Database (SQL)

Provides a fast in-memory database that supports JDBC API and R2DBC access, with a small (2mb) footprint.

Supports embedded and server modes as well as browser based console application.
