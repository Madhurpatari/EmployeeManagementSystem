# Employee Managemet System
This is a simple web application for managing employees and their addresses. 
It is built using the Spring Boot framework and uses a MySQL database for persistence.

## Getting Started
To get started with this project, you will need to have the following tools installed on your machine:

* Java JDK 8 or later
* MySQL database
* Maven build tool

You can then clone this repository to your local machine using the following command:
```java
git clone https://github.com/Madhurpatari/EmployeeManagementSystem.git
```
Once you have cloned the repository, you can import the project into your favorite IDE (such as IntelliJ or Eclipse).

## Configuration
Before running the application, you will need to configure the database connection settings in the application.properties file. 
You can do this by editing the file located at src/main/resources/application.properties. Here's an example configuration:

```java
spring.datasource.url=jdbc:mysql://localhost:3306/database-name
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true
```
Make sure to replace your-password with your actual MySQL password.

## Usage
Once the application is running, you can access the REST API endpoints using a tool such as Postman or curl. Here are the available endpoints:

## EmployeeController
* GET /employees - get all employees
* GET /employees/{id} - get an employee by id
* POST /employees - create a new employee
* PUT /employees/{id} - update an employee by id
* DELETE /employees/{id} - delete an employee by id
## AddressController
* GET /addresses - get all addresses
* GET /addresses/{id} - get an address by id
* POST /addresses - create a new address
* PUT /addresses/{id} - update an address by id
* DELETE /addresses/{id} - delete an address by id
## Contributing
If you would like to contribute to this project, feel free to open a pull request or submit an issue. I welcome all contributions!











