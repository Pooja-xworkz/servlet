package com.xworkz.servletHibernate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xworkz.servletHibernate.dao.ContactDAO;
import com.xworkz.servletHibernate.dao.ContactDAOImpl;
import com.xworkz.servletHibernate.entity.ContactEntity;
import com.xworkz.servletHibernate.service.ContactService;
import com.xworkz.servletHibernate.service.ContactServiceImpl;

public class ContactServlet extends HttpServlet {
	private ContactService service;
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Invoked init");
		service=new ContactServiceImpl();
		
	
		
	}
	

public ContactServlet() {
	System.out.println("created "+this.getClass().getSimpleName());
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("invoked post in ContactServlet ");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phno=req.getParameter("phoneNo");
		
		String yourself=req.getParameter("yourself");
	
		
		resp.setContentType("text/html");
		PrintWriter writer=resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1>");
		writer.println("Contacted by:"+name);
		writer.println("</h1>");
		writer.println("<a href='contact.html'>add more Contact</a>");
		writer.println("</body>");
		writer.println("</html>");
		ContactEntity entity=new ContactEntity(name, email, phno, yourself);
		boolean saved=this.service.validateAndSave(entity);
		
		
		
		if(saved) {
			System.out.println("saved suceesfully");
		}else {
			System.out.println("saved failed");
		}
		
	}
}
