package com.itsc;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MultiplicationServlet")

public class MultiplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		try {
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
			int result = num1 * num2;

			// Set the content type to HTML
			response.setContentType("text/html");

			pw.println("<html>");
			pw.println("<head>");
			pw.println("<link rel=\"stylesheet\" href=\"./css/Style.css\">");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<div class=\"result-container\">");
			pw.println("<h2>Result of Multiplication:</h2>");
			pw.println("<p id=\"result\">" + result + "</p>");
			pw.println("<div class=\"bottom-content\">");
			pw.println("<hr>");
			pw.println("<a href='calculator.html' class=\"button\">Go Back to Calculator</a>");
			pw.println("</div>");
			pw.println("</div>");
			pw.println("</body>");
			pw.println("</html>");
		} catch (NumberFormatException e) {
			// To Handle the case where the input is not a valid number
			pw.println("<p>Error: Please enter valid numeric values.</p>");
		}
	}
}
