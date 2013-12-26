package com.newlecture.mvcprj.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newlecture.mvcprj.dao.MemberDao;
import com.newlecture.mvcprj.dao.NLMemberDao;
import com.newlecture.mvcprj.vo.Member;

@Controller
public class AdminController {
	@Autowired
	private NLMemberDao memberDao;

	@RequestMapping(value={"/admin/member/memberList"}, method=RequestMethod.GET)
	public String memberList(String q, String f, String p, String s, String e, Model md) throws ClassNotFoundException, SQLException
	{
		Object o = 1;
		int pnum=1;
		String field ="name";
		String query ="";
		String	eday="2013-12-23";
		String	sday="1990-12-20";
		
		
		if(f != null)
			field = f;
		if(q != null)
			query = q;
		if(p != null)
			pnum = Integer.parseInt(p);
		if(s != null)
			sday = s;
		if(e != null)
			eday = e;
		

		
		
		List<Member> list= memberDao.getMembers(pnum, field, query, eday, sday);
		md.addAttribute("list",list);
		md.addAttribute("query",query);
		md.addAttribute("sday",sday);
		md.addAttribute("eday",eday);
		md.addAttribute("pnum",pnum);
		md.addAttribute("field",field);

		
		return "admin/member/memberList";
	}
	
	@RequestMapping(value={"/admin/member/memberList"}, method=RequestMethod.POST)
	public String MemberList(String[] uid, String active, String inactive) throws ClassNotFoundException, SQLException
	{
		System.out.println("포스트실행");
		if(uid==null)
		{
			System.out.println("uid 없을때");
			return "redirect:memberList?err=1";
		}
		
		if(active != null)
		{
			System.out.println("액티브");
			for(String id: uid)
				memberDao.activity(id, true);
		}
		
		if(inactive != null)
		{
			System.out.println("인액티브");
			for(String id: uid)
				memberDao.activity(id, false);
		}
		
		return "redirect:memberList";
		
	}
		
}
