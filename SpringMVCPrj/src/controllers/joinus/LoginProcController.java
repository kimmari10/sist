package controllers.joinus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import vo.Student;
import dao.NLStudentDao;
import dao.StudentDao;

public class LoginProcController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		
		StudentDao dao = new NLStudentDao();
		
		Student s = dao.getStudents(uid);
		
		if(s==null)
		{
			System.out.println("회원이 존재하지 않습니다");
		}
		
		else if(!s.getPwd().equals(pwd)) 
		{
			System.out.println("비밀번호가 일치하지 않습니다");
		}
		
		else if(s.getPwd().equals(pwd)) //로그인성공
		{
			HttpSession session = request.getSession();
			session.setAttribute("uid", uid);
			
			String returnURL = (String)session.getAttribute("returnURL"); 
			
			if(returnURL != null )
			{
				session.setAttribute("returnURL", null);
				return new ModelAndView("redirect:"+returnURL);
			}
			else
				return new ModelAndView("redirect:../index.htm"); //타일로반환하지않고 response.redirect기능을 바로 씀
		}
			
		return new ModelAndView("redirect:login.htm");

	}
}