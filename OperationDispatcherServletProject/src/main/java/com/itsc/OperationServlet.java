package com.itsc;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/OperationServlet")

public class OperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");

		if (operation.equals("+")) {
			request.getRequestDispatcher("/AdditionServlet").forward(request, response);
		} else if (operation.equals("*")) {
			request.getRequestDispatcher("/MultiplicationServlet").forward(request, response);
		} else {
			response.getWriter().println("Invalid operation");
		}
	}
}
