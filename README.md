# Expense Tracker Application

This application is a simple expense tracker that allows users to manage their expenses and income, view statistics, and analyze financial data.

## Features

- **Expense Management**:
  - Create, update, delete, and view expenses.
  - Sort and view expenses by date.
  - Track expenses with categories and descriptions.

- **Income Management**:
  - Create, update, delete, and view income records.
  - Sort and view income by date.
  - Track income with categories and descriptions.

- **Statistics and Analysis**:
  - View total income, total expenses, and balance.
  - Get the latest income and expense records.
  - Analyze financial data with minimum and maximum values.
  - Generate charts and graphs for financial trends over time.

## Tech Stack

The application is built using the following technologies:

### Backend

- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white) **Spring Boot**: A framework for building production-ready applications quickly.
- ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white) **MySQL**: A relational database for storing financial records.
- ![Lombok](https://img.shields.io/badge/Lombok-ACDABA?style=for-the-badge&logo=lombok&logoColor=white) **Lombok**: Reduces boilerplate code in Java by generating common methods.
- ![Springdoc OpenAPI](https://img.shields.io/badge/Springdoc%20OpenAPI-85EA2D?style=for-the-badge&logo=openapi-initiative&logoColor=white) **Springdoc OpenAPI**: For generating API documentation.


## Project Structure

### Services

- **ExpenseServiceImpl**: 
  - Manages operations related to expenses, including creating, updating, deleting, and retrieving expense records.
  - Sorts expenses by date and handles exceptions when records are not found.

- **IncomeServiceImpl**: 
  - Manages operations related to income, including creating, updating, deleting, and retrieving income records.
  - Converts `Income` entities to DTOs and handles exceptions when records are not found.

- **StatsServiceImpl**: 
  - Provides statistical analysis and data aggregation.
  - Calculates total income, total expenses, and balance.
  - Generates data for charts and finds minimum and maximum values for income and expenses.

### Dependencies (`pom.xml`)

- **Spring Boot Starter Data JPA**: For ORM and database interaction.
- **Spring Boot Starter Web**: For building RESTful APIs.
- **MySQL Connector**: For connecting the application to a MySQL database.
- **Lombok**: For reducing boilerplate code in Java.
- **Springdoc OpenAPI**: For generating interactive API documentation.
- **Spring Boot Starter Test**: For unit and integration testing.

### Prerequisites

- **Java 17** or higher
- **MySQL(version 8.0 or higher)**

## Getting Started

git clone https://github.com/GrigorianK8/expense-tracker.git
cd expense-tracker
