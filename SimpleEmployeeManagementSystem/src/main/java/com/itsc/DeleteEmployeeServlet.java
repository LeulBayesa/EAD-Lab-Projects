package com.itsc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/deleteurl")

public class DeleteEmployeeServlet extends HttpServlet {
	
   
	private static final long serialVersionUID = 1L;
	private static final String query = "delete from EMPLOYEES where id=?";
	
    @Override
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        
        //link the bootstrap
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
        
        
        //get the id of employees record
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
            int count = ps.executeUpdate();
            
            pw.println("<div class='card' style='margin:auto;width:400px;margin-top:100px'>");
            
            if (count == 1) {
            	
            	pw.println("<h2 class='bg-success text-light text-center'>Employee Record Deleted Successfully</h2>");
                
            } else {
            	pw.println("<h2 class='bg-danger text-light text-center'>Employee Record Is Not Deleted</h2>");
                
            }
        } catch (SQLException se) {
            se.printStackTrace();
            pw.println("<h1 class='bg-danger text-light text-center'>" + se.getMessage() + "</h2>");
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<h1 class='bg-danger text-light text-center'>" + e.getMessage() + "</h2>");
        }
        pw.println("&nbsp; &nbsp;");
		pw.println("<button class=\"btn btn-outline-success d-block\"><a href='index.html'>Home</a></button>");
		pw.println("&nbsp; &nbsp;");
		pw.println("<button class=\"btn btn-outline-success d-block\"><a href='viewEmployee'>View Employees</a></button>");
		pw.println("</div>");

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
