
# **GlowUp Tracker – Assignment 4**

## **1 Project description**

This project is a Java console application.
It is a refactored version of Assignment 3.
The goal of the project is to apply SOLID principles and advanced OOP concepts.
The application works with a PostgreSQL database using JDBC.


## **2 Architecture**

The project uses layered architecture.

1 Controller layer
2 Service layer
3 Repository layer
4 Database layer

Controller works only with services.
Service contains business logic and validation.
Repository works with the database using JDBC.


## **3 SOLID principles**

**1 SRP**
Each class has only one responsibility.
Controller handles user input.
Service handles logic and validation.
Repository handles database operations.

**2 OCP**
New activity types can be added without changing existing code.

**3 LSP**
All activity types are used through the base class.

**4 ISP**
Small and specific interfaces are used instead of one large interface.

**5 DIP**
Service layer depends on repository interfaces, not implementations.


## **4 OOP features**

**1 Abstract class**
SelfCareActivityBase is an abstract class.

**2 Inheritance**
WellnessActivity and ProductivityActivity extend the base class.

**3 Polymorphism**
Activities are handled using the base class reference.

**4 Generics**
Generics are used in CrudService and CrudRepository.

**5 Lambda expressions**
Lambda expressions are used to sort activities.

**6 Reflection**
Reflection is used to print class information at runtime.


## **5 Database**

PostgreSQL database is used.

Database tables:
1 routine_types
2 routines
3 activities

Database features:
1 foreign keys
2 NOT NULL constraints
3 UNIQUE constraint on activity name

Database structure and sample data are defined in **schema.sql**.


## **6 Exception handling**

Custom exceptions are used in the project.

1 InvalidInputException
2 DuplicateResourceException
3 ResourceNotFoundException
4 DatabaseOperationException

Exceptions are handled in service and repository layers.


## **7 Application functionality**

The application supports the following actions.

1 Create activity
2 List all activities
3 Sort activities
4 Get activity by id
5 Delete activity
6 Validation and error handling


## **8 Screenshots**

Screenshots are located in **docs/screenshots**.

They demonstrate:
1 application start
2 CRUD operations
3 sorting
4 exceptions
5 foreign key constraint
6 reflection output


## **9 Reflection**

This assignment helped me understand how SOLID principles are applied in practice.
The most difficult part was working with JDBC and database constraints.
Overall, the project improved my understanding of layered architecture.
