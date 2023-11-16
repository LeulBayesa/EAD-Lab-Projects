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

@WebServlet("/editScreen")
public class EditEmployeeServlet extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	private static final String query = "SELECT NAME,DESIGNATION,SALARY FROM EMPLOYEES WHERE id=?";
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        
        //link the bootstrap CSS
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
        
        
        //get the Id of employee record
        int id = Integer.parseInt(req.getParameter("id"));
        
        //LOAD JDBC driver
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }
        //generate the connection
        try (Connection con = DriverManager.getConnection("jdbc:mysql:///myemployees", "root", "root"); 
        		
        	PreparedStatement ps = con.prepareStatement(query);) {
        	
        	ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            pw.println("<div class='card' style='margin:auto;width:400px;margin-top:100px;'>");
            pw.println("<form action='edit?id="+id+"' method='post' class=\"form card\">");
            pw.println("<table class='table table-hover table-striped'>");
            pw.println("<tr>");
            pw.println("<td>Employee Name</td>");
            pw.println("<td><input type='text' name='employeeName' value='"+rs.getString(1)+"'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>Employee Designation</td>");
            pw.println("<td><input type='text' name='employeeDesignation' value='" + rs.getString(2) + "'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
            pw.println("<td>Employee Salary</td>");
            pw.println("<td><input type='text' name='employeeSalary' value='" + rs.getFloat(3) + "'></td>");
            pw.println("</tr>");
            pw.println("<tr card-footer>");
            pw.println("<td><button type='submit' class='btn btn-outline-success'>Edit</button></td>");
            pw.println("<td><button type='reset' class='btn btn-outline-danger'>Cancel</button></td>");
            pw.println("</tr>");
            pw.println("</table>");
            pw.println("</form>");

        } catch (SQLException se) {
        	se.printStackTrace();
        	pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<h2 class='bg-danger text-light text-center'>"+e.getMessage()+"</h2>");
        }
        pw.println("<button class=\"btn btn-outline-success d-block\"><a href='index.html'>Home</a></button>");
        pw.println("</div>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
	
}
