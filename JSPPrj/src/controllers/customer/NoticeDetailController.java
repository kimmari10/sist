package controllers.customer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Notice;
import dao.NLNoticeDao;
import dao.NoticeDao;

public class NoticeDetailController {

	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException
	{
		String seq = request.getParameter("seq");

		NoticeDao dao = new NLNoticeDao();
		Notice n = dao.getNotice(seq);
		
		request.setAttribute("n", n);
		
		request.getRequestDispatcher("noticeDetail.jsp").forward(request, response); 
		
	}
}
