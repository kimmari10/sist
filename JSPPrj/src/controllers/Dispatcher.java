package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.customer.NoticeController;
import controllers.customer.NoticeDetailController;

@WebServlet("/Dispatcher")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		
//		System.out.println("url = "+url+"<br  />");
//		System.out.println("uri = "+uri+"<br  />");
		
		try {
			if (uri.equals("/JSPPrj/customer/notice.htm")) 
			{
				NoticeController cont = new NoticeController();
				cont.execute(request, response);
			}
			else if (uri.equals("/JSPPrj/customer/noticeDetail.htm")) 
			{
				NoticeDetailController cont = new NoticeDetailController();
				cont.execute(request, response);
			}			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		service(request, response);
	}

}
