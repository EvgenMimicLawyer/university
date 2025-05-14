# University Library Management System

This is a Java-based library management system for universities. The system allows for managing books, authors, and library operations efficiently.

## Features

- Author management (add, edit, delete authors)
- Book management (add, edit, delete books)
- Relationship management between books and authors
- Data persistence using JPA/Hibernate

## Technology Stack

- Java
- Spring Boot
- JPA/Hibernate
- PostgreSQL/MySQL (database)
- Maven/Gradle (build tool)

## Project Structure

The project follows a standard Maven/Spring Boot structure:

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── university/
│   │           └── library/
│   │               ├── model/
│   │               ├── repository/
│   │               ├── service/
│   │               └── controller/
│   └── resources/
└── test/
```

## Getting Started

1. Clone the repository
2. Configure your database connection in `application.properties`
3. Run the application using your IDE or Maven/Gradle
4. Access the application through the defined endpoints

## Contributing

Feel free to submit issues and enhancement requests. 