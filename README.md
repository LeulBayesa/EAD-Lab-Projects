# Simple Employee Management System

This is a basic Employee Management System implemented using Java servlets, JDBC, and Apache Tomcat. The application provides CRUD (Create, Read, Update, Delete) operations on an Employee entity.

## Table of Contents

- [Database Setup](#database-setup)
- [Servlets](#servlets)
- [Forms](#forms)
- [JDBC](#jdbc)
- [Apache Tomcat](#apache-tomcat)
- [Testing](#testing)

## Database Setup

- Set up a MySQL database with a table named `employees`. The table should have the following columns:
  - `id` (auto-incremented primary key)
  - `name` (employee name)
  - `designation` (employee designation)
  - `salary` (employee salary)

## Servlets

1. **AddEmployeeServlet:**
   - Display a form to add a new employee.
   - Process the form data and insert a new employee into the database.

2. **ViewEmployeesServlet:**
   - Retrieve all employees from the database and display them in a tabular format.

3. **EditEmployeeServlet:**
   - Display a form to edit an existing employee.
   - Process the form data and update the employee in the database.

4. **DeleteEmployeeServlet:**
   - Delete an employee from the database.

## Forms

- Create HTML forms for adding and editing employees. These forms should include input fields for name, designation, and salary.

## JDBC

- Use JDBC to interact with the MySQL database.
- Implement methods for connecting to the database, executing SQL queries, and handling CRUD operations.

## Apache Tomcat

- Deploy your application on Apache Tomcat.
- Configure the database connection in a way that is portable between different environments.

## Testing

- Manually test each CRUD operation to ensure they work as expected.
- Test error scenarios, such as submitting a form with invalid data.

## Getting Started

Clone the repository:
```bash
git clone https://github.com/leulbayesa/SimpleEmployeeManagementSystem.git
```

## Demo

![Demo Image](https://github.com/LeulBayesa/EmployeeManagementSystem/blob/main/Img/Directory%20.png)
![Demo Image](https://github.com/LeulBayesa/EmployeeManagementSystem/blob/main/Img/Screen.png)
![Demo Image](https://github.com/LeulBayesa/EmployeeManagementSystem/blob/main/Img/Employee-List.png)
![Demo Image](https://github.com/LeulBayesa/EmployeeManagementSystem/blob/main/Img/Added.png)
