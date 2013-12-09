package controllers.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class NoticeRegController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		
		if(session.getAttribute("uid") == null)
		{
			session.setAttribute("returnURL", "../customer/noticeReg.htm");
			return new ModelAndView("redirect:../joinus/login.htm");
		}
			return new ModelAndView("customer.noticeReg");
	}
}