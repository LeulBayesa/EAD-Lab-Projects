# Simple Calculator Web Application

This repository contains a basic web calculator application implemented using Java Servlets. The calculator allows users to input two numbers and choose between addition (+) and multiplication (*) operations. The application is divided into three servlets: `AdditionServlet`, `MultiplicationServlet`, and `OperationServlet`. The `OperationServlet` acts as a dispatcher, invoking either the addition or multiplication servlet based on the user's choice.

## Table of Contents

- [File Structure](#file-structure)
- [How to Run](#how-to-run)
- [Usage](#usage)
- [Servlet Details](#servlet-details)
  - [AdditionServlet](#additionservlet)
  - [MultiplicationServlet](#multiplicationservlet)
  - [OperationServlet](#operationservlet)
- [Demo](#demo)

## File Structure

- `calculator.html`: HTML file with input fields for `num1` and `num2` and a selection option for the operation.
- `AdditionServlet.java`: Servlet class for handling addition operation.
- `MultiplicationServlet.java`: Servlet class for handling multiplication operation.
- `OperationServlet.java`: Servlet class acting as a dispatcher based on the selected operation.

## How to Run

1. Install a Java Servlet container like Apache Tomcat.
2. Deploy compiled servlet classes.
3. Start the servlet container.
4. Access `calculator.html` in your browser.

## Usage

1. Open the `calculator.html` file in a web browser or run the project directory.
2. Enter numerical values for `num1` and `num2`.
3. Choose the desired operation from the dropdown menu (+ or *).
4. Click the "Calculate" button.

## Servlet Details

### AdditionServlet

- Handles addition operation.
- Reads values of `num1` and `num2` from the request.
- Performs addition and sends the result back to the client.

### MultiplicationServlet

- Handles multiplication operation.
- Reads values of `num1` and `num2` from the request.
- Performs multiplication and sends the result back to the client.

### OperationServlet

- Acts as a dispatcher based on the selected operation.
- Invokes `AdditionServlet` for addition operation.
- Invokes `MultiplicationServlet` for multiplication operation.

## Demo

Clone the repository:
```bash
git clone https://github.com/leulbayesa/SimpleEmployeeManagementSystem.git
```

## Demo
![Demo cal-home](https://github.com/LeulBayesa/SimpleEmployeeManagementSystem/blob/master/Img/cal-screenshot/cal-home.png)

![Demo cal-home2](https://github.com/LeulBayesa/SimpleEmployeeManagementSystem/blob/master/Img/cal-screenshot/cal-home2.png)
![Demo cal-result ](https://github.com/LeulBayesa/SimpleEmployeeManagementSystem/blob/master/Img/cal-screenshot/cal-result.png)
![Demo cal-result2 ](https://github.com/LeulBayesa/SimpleEmployeeManagementSystem/blob/master/Img/cal-screenshot/cal-result2.png)

![Demo cal-error ](https://github.com/LeulBayesa/SimpleEmployeeManagementSystem/blob/master/Img/cal-screenshot/cal-error.png)
![Demo cal-dir ](https://github.com/LeulBayesa/SimpleEmployeeManagementSystem/blob/master/Img/cal-screenshot/cal-dir.png)

