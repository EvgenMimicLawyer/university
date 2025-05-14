# Library Management System

A Spring Boot application for managing books and authors in a library system.

## Features

### Author Management
- Create new authors
- Get all authors
- Get author by ID
- Get all books by specific author

### Book Management
- Create new books (with author reference)
- Get all books
- Get book by ID

## Entity Structure

### Author
- id (Long)
- name (String)
- country (String)
- books (One-to-Many relationship)

### Book
- id (Long)
- title (String)
- genre (String)
- author (Many-to-One relationship)

## API Endpoints

### Authors
- POST /authors - Create a new author
- GET /authors - Get all authors
- GET /authors/{id} - Get author by ID
- GET /authors/{id}/books - Get all books by an author

### Books
- POST /books - Create a new book (requires authorId)
- GET /books - Get all books
- GET /books/{id} - Get book by ID

## Technologies
- Java
- Spring Boot
- Spring Data JPA
- Jakarta Persistence
- RESTful API

## Contact
For any questions, please contact: foxmossaur@gmail.com 