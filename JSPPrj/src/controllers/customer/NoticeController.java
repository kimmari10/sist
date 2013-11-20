package controllers.customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Notice;
import dao.NLNoticeDao;
import dao.NoticeDao;

public class NoticeController {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException
	{
		
		String p = request.getParameter("p"); //페이지
		String q = request.getParameter("q"); //검색어
		String f = request.getParameter("f"); //제목&내용
		
		
		int pnum=1;
		String field = "TITLE";
		String query = "%%";
//		-> SELECT * FROM NOTICES WHERE TITLE LIKE '%%'
		
		if(f != null)
			field = f;
		
		if(q != null)
			query = "%"+q+"%";
		
		if (p!=null)
			pnum = Integer.parseInt(p);
		
		
		NoticeDao dao = new NLNoticeDao();
		
		List<Notice> list = dao.getNotices(pnum, field, query);
		
		int cnt = dao.getTotalCount();
		int start = pnum - ((pnum-1)%5);
		int end = (cnt-1)/15+1;
		
		
		request.setAttribute("list", list);
		request.setAttribute("p", pnum);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("f", field);
		request.setAttribute("q", q);
		
		
		request.getRequestDispatcher("notice.jsp").forward(request, response);
		
	}
}
