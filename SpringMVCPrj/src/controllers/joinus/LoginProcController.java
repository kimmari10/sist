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
			System.out.println("ȸ���� �������� �ʽ��ϴ�");
		}
		
		else if(!s.getPwd().equals(pwd)) 
		{
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
		}
		
		else if(s.getPwd().equals(pwd)) //�α��μ���
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
				return new ModelAndView("redirect:../index.htm"); //Ÿ�Ϸι�ȯ�����ʰ� response.redirect����� �ٷ� ��
		}
			
		return new ModelAndView("redirect:login.htm");

	}
}