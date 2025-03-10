# Spring Boot Fullstack Project with JWT

![Java](https://img.shields.io/badge/Java-38.7%25-blue)
![TypeScript](https://img.shields.io/badge/TypeScript-35.2%25-blue)
![HTML](https://img.shields.io/badge/HTML-18.6%25-blue)
![SCSS](https://img.shields.io/badge/SCSS-7.5%25-blue)

## Overview

This project is a full-stack web application built with Spring Boot for the backend and Angular for the frontend. It implements JWT (JSON Web Token) authentication to secure the application.

## Features

- User authentication with JWT
- Role-based access control
- CRUD operations for data management
- Responsive UI design

## Technologies Used

### Backend

- **Java**: The primary language for the backend.
- **Spring Boot**: For creating stand-alone, production-grade Spring-based applications.
- **Spring Security**: For handling authentication and authorization.
- **JWT**: For secure token-based authentication.
- **Hibernate**: For ORM (Object Relational Mapping).

### Frontend

- **Angular**: The primary framework for the frontend.
- **TypeScript**: The primary language for the frontend.
- **HTML & SCSS**: For structuring and styling the frontend.

## Getting Started

### Prerequisites

- Java 8 or higher
- Node.js and npm
- Angular CLI
- MySQL or any other relational database

### Installation

#### Backend

1. Clone the repository:
    ```bash
    git clone https://github.com/Sankalpa0011/Spring-Boot-Fullstack-Project-With-JWT.git
    cd Spring-Boot-Fullstack-Project-With-JWT
    ```

2. Navigate to the backend directory:
    ```bash
    cd backend
    ```

3. Configure the database in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

4. Build and run the backend:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

#### Frontend

1. Navigate to the frontend directory:
    ```bash
    cd frontend
    ```

2. Install dependencies:
    ```bash
    npm install
    ```

3. Run the frontend:
    ```bash
    ng serve
    ```

## Usage

1. Open your browser and navigate to `http://localhost:4200`.
2. Register a new account or log in with existing credentials.
3. Use the application to manage your data.

## Folder Structure

- `backend/`: Contains the Spring Boot application.
    - `src/main/java/`: Java source files.
    - `src/main/resources/`: Configuration files and resources.
- `frontend/`: Contains the Angular application.
    - `src/app/`: Angular components, services, and modules.
    - `src/assets/`: Static assets like images and styles.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -m 'Add some feature'`).
4. Push the branch (`git push origin feature-branch`).
5. Open a Pull Request.
