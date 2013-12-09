package controllers.customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import vo.Notice;
import dao.NLNoticeDao;
import dao.NoticeDao;

public class NoticeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
						
				String f = request.getParameter("f");
				String q = request.getParameter("q");
				String p = request.getParameter("p");

				int pnum = 1;
				String field = "TITLE";
				String query = "%%";  
				// -> SELECT * FROM NOTICES WHERE TITLE LIKE '%%'
						
				if(f != null)
					field = f;
				if(q != null)
					query = q;
				if(p != null)
						pnum = Integer.parseInt(p);

				NoticeDao dao = new NLNoticeDao();
				List<Notice> list = dao.getNotices(pnum, field, query);

				int cnt = dao.getTotalCount();
				int start = pnum - ((pnum-1)%5);
				int end = (cnt-1)/15+1;
				
				ModelAndView mv = new ModelAndView("customer.notice");
								
				mv.addObject("list", list);
				mv.addObject("p", pnum);
				mv.addObject("start", start);
				mv.addObject("end", end);

				return mv;
	}
}
