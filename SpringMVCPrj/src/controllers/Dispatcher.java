package controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	private List<String> urls;
	private List<Controller> ctrls;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);		
		
		String mapfile = config.getInitParameter("mapfile");
		
		urls = new ArrayList();
		ctrls = new ArrayList();
		
		String path = config.getServletContext().getRealPath(mapfile);
		
		try {
			FileInputStream fin = new FileInputStream(path);
			Scanner scan = new Scanner(fin);
			
			while(scan.hasNext())
			{
				String line  = scan.nextLine();
				String[] data = line.split(" ");
				String url = data[0];
				String ctrl = data[1];
				
				urls.add(url);
				ctrls.add((Controller)Class.forName(data[1]).newInstance());
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		//String url = request.getRequestURL().toString();
		String ctxName = request.getServletContext().getContextPath();
		//"/SpringMVCPrj"
		
		String uri = request.getRequestURI();	
		if(uri.indexOf(ctxName) == 0)
			uri = uri.substring(ctxName.length());
		//System.out.println("url:" + url + "<br />");// http://localhost//...
		//System.out.println("uri:" + uri + "<br />");// /JSPPrj/customer/notic
		
		String cxtName = request.getServletContext().getContextPath();
						
		try {
			Controller controller = new ErrorController();
			
			String url = "";
			for(int i=0; i<urls.size(); i++)
				if(uri.equals(urls.get(i)))
				{
					controller = ctrls.get(i);
					url = controller.execute(request, response);
				}
			
			request.getRequestDispatcher(url).forward(request, response);
			
			/*NoticeEditController controller = new NoticeEditController();*/
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
