# Assignment

## Description
This is a demo project for Spring Boot, designed to showcase a basic web application using Spring Data JPA, Thymeleaf, and MySQL. The project demonstrates how to create a simple web application structure with a focus on best practices in Spring Boot development.

## Technologies Used
- **Java 1.8**
- **Spring Boot 2.7.8**
- **Spring Data JPA**
- **Thymeleaf**
- **MySQL**
- **Lombok**

## Dependencies

### Required Software
To set up and run this project, ensure you have the following installed:

1. **Java Development Kit (JDK)**: Version 1.8 or higher.
2. **Maven**: Version 3.6.0 or higher for building the project.
3. **MySQL**: Version 5.7 or higher for the database.
4. **An IDE**: (Optional but recommended) such as IntelliJ IDEA or Eclipse for easier project management.

### Maven Dependencies
The following dependencies are included in the `pom.xml` file:

- **Spring Boot Starter Data JPA**: For data access and JPA integration.
- **Spring Boot Starter Web**: For building web applications.
- **Spring Boot Starter Thymeleaf**: For server-side templating.
- **MySQL Connector**: For connecting to a MySQL database.
- **Lombok**: For reducing boilerplate code in Java.
- **Spring Boot Starter Test**: For testing support.

## Build Instructions

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd assignment


## Set Up MySQL Database

Create a new database in MySQL. You can use the following SQL command:
CREATE DATABASE assignment_db;

Update your application.properties file (located in src/main/resources) to configure the database connection. Here's an example configuration:

- spring.datasource.url=jdbc:mysql://localhost:3306/assignment_db
- spring.datasource.username=<your-username>
- spring.datasource.password=<your-password>
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.show-sql=true   

##Access the Application Open your web browser and navigate to:

http://localhost:9090/index.html