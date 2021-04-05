package com.xworkz.servletHibernate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xworkz.servletHibernate.entity.ContactEntity;
import com.xworkz.servletHibernate.service.ContactService;
import com.xworkz.servletHibernate.service.ContactServiceImpl;

public class SearchByEmailServlet extends HttpServlet {
	private ContactService service;
	 @Override
	public void init(ServletConfig config) throws ServletException {
		this.service=new ContactServiceImpl();
	}
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("invoked dopost in SearchByEmailServlet");
	String email=req.getParameter("email");
	System.out.println("email"+email);
	ContactEntity entityFromService=this.service.validateAndSaveSearchByEmail(email);
	System.out.println("entityFromService :"+entityFromService);
	resp.setContentType("text/html");
	PrintWriter writer=resp.getWriter();
	writer.println("<html>");
	writer.println("<body>");
	writer.println("<form action=\"searchByEmail\" method=\"post\">\r\n" + 
			"<h1>Search By Email</h1>\r\n" + 
			"Search By Email: <input type=\"text\" name=\"email\">\r\n" + 
			"<input type=\"submit\" value =\"search\">\r\n" + 
			"</form>");
	if(entityFromService!=null) {
		writer.println("<p>Search Results Found</br>" +entityFromService.getName()+ "Search Results Found"+entityFromService.getEmail()+"</p>");
	}else {
		writer.println("<p style= 'colour:red;'>No Results Found</p>");
	}
	writer.println("</body>");
	writer.println("</html>");
}
}
