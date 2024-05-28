# Student Management System

This web application is designed to manage student records using Java, Servlet, and JDBC. It provides basic CRUD (Create, Read, Update, Delete) operations for adding, updating, and deleting student information stored in a MySQL database.

## Features

- **CRUD Operations:** Allows users to perform CRUD operations on student records.
- **Add Student:** Add a new student to the database with details such as StudentId, Name, Age, Address.
- **Update Student:** Modify existing student information such as Name,Age, Address.
- **Delete Student:** Remove a student from the database.
- **View Students:** Display a student details currently stored in the database.

## Technologies Used

- **Java:** Used as the primary programming language for backend logic.
- **Servlet:** Handles HTTP requests and generates responses.
- **JDBC (Java Database Connectivity):** Enables Java applications to interact with the MySQL database.
- **MySQL:** Database management system used for storing and retrieving student data.

## Setup

1. **Database Setup:**
   - Install MySQL database server.
   - Create a new database named `student`.
   - Import the provided SQL script `student_records.sql` to create necessary tables and sample data.

2. **IDE Setup:**
   - Import the project into your preferred Java IDE (Eclipse).

3. **Deployment:**
   - Deploy the application on a servlet container ( Apache Tomcat).
   - Ensure the servlet container is configured correctly to handle JDBC connections.

4. **Configuration:**
   - Modify the `application.properties` file to provide your MySQL database credentials (username, password, etc.).

5. **Run:**
   - Start the servlet container.
   - Access the application through the specified URL.

## Usage

- Upon accessing the application, users will be presented with a user interface to perform CRUD operations on student records.
- Navigate through the interface to add, update, delete, or view student information.

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Create a new Pull Request.

Feel free to customize this README according to your project's specific requirements and additional features
