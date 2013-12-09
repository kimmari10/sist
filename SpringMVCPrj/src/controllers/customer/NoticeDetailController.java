package controllers.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import vo.Notice;
import dao.NLNoticeDao;

public class NoticeDetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String seq = request.getParameter("seq");
		
		NLNoticeDao dao = new NLNoticeDao();
		Notice n = dao.getNotice(seq);
		
		ModelAndView mv = new ModelAndView("customer.noticeDetail");
		mv.addObject("n", n);
		
		return mv;
	}
}
