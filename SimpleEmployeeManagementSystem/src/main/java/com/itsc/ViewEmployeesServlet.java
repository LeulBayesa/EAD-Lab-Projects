package com.itsc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewEmployee")

public class ViewEmployeesServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String query = "SELECT ID,NAME,DESIGNATION,SALARY FROM EMPLOYEES";
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        
        //set content type
        res.setContentType("text/html");
        
      //link the bootstrap
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
        
        //LOAD JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }
        //generate the connection
        try (Connection con = DriverManager.getConnection("jdbc:mysql:///myemployees", "root", "root"); 
        		
        		PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            pw.println("<div class='card' style='margin:auto;width:600px;margin-top:100px'>");
            
            pw.println("<center><h2 class=\"bg-success text-white card-header\">Employees List</h2></center>");
            pw.println("<table class='table table-hover table-striped'>");
            pw.println("<tr>");
            pw.println("<th>Employee ID</th>");
            pw.println("<th>Employee Name</th>");
            pw.println("<th>Employee Designation</th>");
            pw.println("<th>Employee Salary</th>");
            pw.println("<th>Edit</th>");
            pw.println("<th>Delete</th>");
            pw.println("</tr>");
            while (rs.next()) {
                pw.println("<tr>");
                pw.println("<td>" + rs.getInt(1) + "</td>");
                pw.println("<td>" + rs.getString(2) + "</td>");
                pw.println("<td>" + rs.getString(3) + "</td>");
                pw.println("<td>" + rs.getFloat(4) + "</td>");
                pw.println("<td><a href='editScreen?id=" + rs.getInt(1) + "'>Edit</a></td>");
                pw.println("<td><a href='deleteurl?id=" + rs.getInt(1) + "'>Delete</a></td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
        } catch (SQLException se) {
            se.printStackTrace();
            pw.println("<h1>" + se.getMessage() + "</h2>");
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<h1>" + e.getMessage() + "</h2>");
        }
        pw.println("<button class=\"btn btn-outline-success d-block\"><a href='index.html'>Home</a></button>");
        pw.println("</div>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}