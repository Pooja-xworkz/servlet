package com.xworkz.servletHibernate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xworkz.servletHibernate.entity.ContactEntity;
import com.xworkz.servletHibernate.service.ContactService;
import com.xworkz.servletHibernate.service.ContactServiceImpl;

public class DisplayAllServelet extends HttpServlet{
	private ContactService service;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.service=new ContactServiceImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("invoked dopost in DisplayAllServelet");
		List<ContactEntity> listFromService=this.service.getall();
		resp.setContentType("text.html");
		PrintWriter writer=resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		if(listFromService!=null && !listFromService.isEmpty()) {
			System.out.println("list is found with size "+listFromService.size());
			writer.println("<h1>Result found ,total :"+listFromService.size() +"</h1>");
			writer.println("<table border='1'>");
			Iterator<ContactEntity> iterator=listFromService.iterator();
			while(iterator.hasNext()) {
				ContactEntity element=iterator.next();
				writer.println("<tr>");
				writer.println("<td>"+element.getName()+"</td>");
				writer.println("<td>"+element.getEmail()+"</td>");
				writer.println("<td>"+element.getPhoneno()+"</td>");
				writer.println("<td>"+element.getAbouturself()+"</td>");
				writer.println("</tr>");
			}
		}
		writer.println("</table>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
