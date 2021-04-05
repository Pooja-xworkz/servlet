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

public class SearchByNameServelet extends HttpServlet {
	private ContactService service;
	public SearchByNameServelet() {
		System.out.println("created" +this.getClass().getSimpleName() );
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		this.service=new ContactServiceImpl();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("invoked dopost in SearchByNameServelet ");
		String name=req.getParameter("name");
		ContactEntity entityFromService=this.service.validateAndSaveSearchByName(name);
		System.out.println("entityFromService :"+entityFromService);
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<form action=\"searchByName\" method=\"post\">\r\n" + 
				"<h1>Search By Name</h1>\r\n" + 
				"Search By Name: <input type=\"text\" name=\"name\">\r\n" + 
				"<input type=\"submit\" value =\"search\">\r\n" + 
				"</form>");
		if(entityFromService!=null) {
			writer.println("<p>Search Results Found</br>" +entityFromService.getName()+"</p>");
		}else {
			writer.println("<p style= 'colour:red;'>No Results Found</p>");
		}
		writer.println("</body>");
		writer.println("</html>");
		
		
		
	}

}
