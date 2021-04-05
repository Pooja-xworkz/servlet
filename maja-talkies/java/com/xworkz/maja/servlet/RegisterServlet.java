package com.xworkz.maja.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
 public RegisterServlet() {
	System.out.println("Created "+this.getClass().getSimpleName());
}
 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("invoked doPost from RegisterServlet");
		String name=req.getParameter("name");
		String hobbies=req.getParameter("hobbies");
		String location=req.getParameter("location");
		String email=req.getParameter("email");
		System.out.println("req values");
		System.out.println(name+" "+hobbies+" "+location+" "+email);
		if(name!=null && email!=null && hobbies!=null && location!=null && !name.isEmpty() && !email.isEmpty() && !hobbies.isEmpty() && !location.isEmpty()) {
			System.out.println("Registration is success");
			RequestDispatcher dispatcher=req.getRequestDispatcher("/index.jsp");
			req.setAttribute("msg", "Registration is success");
			dispatcher.forward(req,resp);
		}else {
			System.out.println("Registration is failed");
			RequestDispatcher dispatcher=req.getRequestDispatcher("/index.jsp");
			req.setAttribute("msg", "Registration is failed");
			dispatcher.forward(req,resp);
		}
		
	}
}
