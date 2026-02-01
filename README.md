
# GlowUp Tracker — Assignment 4 (SOLID & Advanced OOP)

## Project Overview

This project is a **CLI-based Java application** called **GlowUp Tracker**.
It helps track self-care activities (wellness and productivity) using a layered architecture and a PostgreSQL database.

The project was refactored from Assignment 3 to follow **SOLID principles**, use **advanced OOP features**, and apply a clean **controller → service → repository → database** structure.

## Technologies Used

* Java
* PostgreSQL
* JDBC
* IntelliJ IDEA
* pgAdmin
* Git

## Architecture

The project follows a **layered architecture**:

* **Controller layer**
  Handles user input from CLI and delegates actions to the service layer.
  No business logic is placed here.

* **Service layer**
  Contains business logic, validation, and exception handling.
  Works only with repository interfaces (Dependency Inversion Principle).

* **Repository layer**
  Responsible for all database operations using JDBC.
  Implements generic CRUD interfaces.

* **Database layer**
  PostgreSQL database with related tables and foreign keys.


## SOLID Principles

### SRP (Single Responsibility Principle)

Each class has only one responsibility:

* Controllers handle input/output
* Services handle business logic and validation
* Repositories handle database access

### OCP (Open–Closed Principle)

New activity types can be added by extending the abstract base class without modifying existing logic.

### LSP (Liskov Substitution Principle)

WellnessActivity and ProductivityActivity can be used through the base class SelfCareActivityBase.

### ISP (Interface Segregation Principle)

Small and focused interfaces are used, such as:

* CrudService<T>
* CrudRepository<T>
* Printable
* Validatable<T>

### DIP (Dependency Inversion Principle)

Services depend on repository **interfaces**, not implementations.
Dependencies are injected in Main.


## OOP & Advanced Features

### Abstract Class & Polymorphism

SelfCareActivityBase is an abstract class with common fields and methods.
Subclasses:

* WellnessActivity
* ProductivityActivity

Polymorphism is used when working with activities through the base type.

### Generics

Generics are used in:

* CrudService<T>
* CrudRepository<T>

This allows code reuse for different entities.

### Lambda Expressions

Lambda expressions are used for sorting activities by score in the service layer.

### Reflection

Reflection is demonstrated using a utility class that prints:

* Class name
* Fields
* Methods

This shows runtime type inspection (RTTI).

### Interface Default / Static Methods

Interfaces include default and static methods (e.g. in validation and printing utilities).


## Database Design

The database contains related tables:

* routine_types
* routines
* activities

Features:

* Foreign keys between tables
* NOT NULL constraints
* UNIQUE constraint on activity name
* Sample data inserted using schema.sql


## Exception Handling

Custom exception hierarchy is used:

* InvalidInputException
* DuplicateResourceException
* ResourceNotFoundException
* DatabaseOperationException

All exceptions are thrown from the **service or repository layer**, not from controllers.


## How to Run the Project

### 1. Compile


javac -cp "lib/postgresql.jar" -d out $(find src -name "*.java")


### 2. Run


java -cp "out:lib/postgresql.jar" Main


## Application Features (CLI)

* Create Wellness and Productivity activities
* List all activities
* Sort activities by score
* Get activity by ID
* Delete activities
* Validation and exception handling
* Database integrity checks (foreign keys)


## Screenshots

Screenshots of the following are provided in docs/screenshots:

* Application start
* CRUD operations
* Sorting using lambda
* Exception handling
* Foreign key constraint error
* Reflection output


## Reflection

During this project, I learned how to properly structure a Java application using SOLID principles.
The most challenging part was connecting JDBC with polymorphic entities and handling database constraints correctly.

This project helped me understand why layered architecture and clean separation of responsibilities are important in real applications.


## Conclusion

This project demonstrates the use of:

* SOLID principles
* Advanced Java OOP features
* JDBC with PostgreSQL
* Clean and maintainable architecture

