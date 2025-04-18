# JDBC Project

This project demonstrates how to use Java Database Connectivity (JDBC) to interact with a MySQL database. The example includes functionality for updating student data in a database using SQL queries.

## Features
- Update student information (name, age, marks) in the database.
- Support for updating specific fields or all fields at once.
- GUI interface for easier interaction with the database (using Java Swing).
- Connection to MySQL database using JDBC.

## Requirements

To run this project, you need the following:

- **Java Development Kit (JDK)** 8 or higher.
- **MySQL** installed and running on your local machine (or a remote MySQL server).
- **MySQL Connector/J** (JDBC driver) for connecting Java to MySQL.

## Setting up the Environment

### 1. Install MySQL:
Ensure you have MySQL installed and running. You can download MySQL from the official website:
[MySQL Downloads](https://dev.mysql.com/downloads/).

### 2. Set Up the Database:
Create a database and a table in MySQL for storing student information.

```sql
CREATE DATABASE mydb;
USE mydb;

CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    marks FLOAT
);
# JDBC
