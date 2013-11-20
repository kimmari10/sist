import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Nana extends HttpServlet
{

	public void doGet(HttpServletRequest request,
				HttpServletResponse response)
				throws IOException, ServletException
	{	
		service(request, response);
	}

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		service(request, response);
	}
		
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
//		int x =0;
//		int y =0;
//		
//		if(request.getMethod().equals("POST"));
//		{
//			String sx = request.getParameter("x");
//			String sy = request.getParameter("y");
//			
//			x = Integer.parseInt(sx);
//			y = Integer.parseInt(sy);
//		}
		
		
		out.write("<!DOCTYPE html>");
		out.write("		<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");

		out.write("<body>");
		out.write("<form action=\"calc\" method=\"post\">");
		out.write("<ul>");
		out.write("<li> <label for=\"x\">X : </label> <input name =\"x\" /> </li>");
		out.write("<li> <label for=\"y\">Y : </label> <input name =\"y\" /> </li>");
		out.write("</ul>");
		out.write("<p> result : ");
//		out.printf("%d", x+y);
		out.write("</p>");
		
		out.write("<p><input type=\"submit\" value=\"µ¡¼À\" /></p>");
		out.write("</form>");
		out.write("</body>");

		out.write("</html>");
		
	}
		
}

