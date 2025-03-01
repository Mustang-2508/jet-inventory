# Jet Inventory

## Table of Contents
- [Tech Stack and Tools](#tech-stack-and-tools)
- [How to Run the Application](#how-to-run-the-application)
- [API Documentation](#api-documentation-)
- [Key Concepts Used in This Application](#key-concepts-used-in-this-application)


## **Tech Stack and Tools**
- **Java:** 11
- **Spring Boot:** 2.1.4.RELEASE
- **Hibernate:** 5.6.15.Final
- **Database:** mysql 8.0.15
- **ModelMapper:** 3.1.1
- **lombok:** 1.18.34
- **mockito-core:** 2.28.2
- **:mockito-junit-jupiter** 2.28.2

## **How to Run the Application**
1. Clone the repository.
    ```
    https://github.com/Mustang-2508/jet-inventory.git
    ```
2. Install Java 11 and Maven.
3. Install **8.0.19(MySql Community Server -GPL)** and configure the database
4. Update below properties connection properties in [application.properties](src%2Fmain%2Fresources%2Fapplication.properties) file.
    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/jet_inventory
    spring.datasource.username=abc
    spring.datasource.password = *****
   ```
5. Run Tests : `mvn test`
6. Run: `mvn spring-boot:run`


## **API Documentation** ##
- **Please refer below link for API documentation:**

    https://documenter.getpostman.com/view/21753761/2sAYdhKqG2
  

## **Key Concepts Used in This Application**

### **1. Hibernate Inheritance Mapping**
- **Inheritance strategies**  `JOINED` is used to manage entity hierarchies efficiently.
- Example: `Interceptor` extends `FighterJet`.

### **2. Exception Handling**
- Centralized exception handling using `@RestontrollerAdvice` and `@ExceptionHandler` for handling validation and business logic errors.

### **3. CRUD Operations**
- Full **Create, Read, Update, Delete (CRUD)** operations implemented using Spring Data JPA and Hibernate.

### **4. DTO & ModelMapper**
- Used **DTO (Data Transfer Object)** pattern and **ModelMapper** to map between entity and DTO.

### **5. Optimistic Locking**
- Used `@Version` to manage  concurrent updates to an entity by ensuring that no two transactions override each other's changes accidentally.

### **6. Lifecycle callback annotations**
- Used `@PrePersist` and `@PreUpdate` to execute logic before an entity is persisted or updated in the database.



