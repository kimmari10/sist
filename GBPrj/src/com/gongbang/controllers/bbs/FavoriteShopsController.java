package com.gongbang.controllers.bbs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.gongbang.dao.FavoriteDao;
import com.gongbang.dao.GBFavoriteDao;
import com.gongbang.vo.Favorite;


public class FavoriteShopsController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 /**
		 *ī�װ��� �������� �޾ƿ� 
		**/
		String id="����"; //�ӽ�
		String category = request.getParameter("cate"); 
		String p = request.getParameter("p"); 
		String type = request.getParameter("t");
		
		int pnum=1;
		category ="%%";
//		-> SELECT * FROM NOTICES WHERE TITLE LIKE '%%'
		
		
		if (p!=null)
			pnum = Integer.parseInt(p);
		
		
		FavoriteDao dao = new GBFavoriteDao();
		
		List<Favorite> list = dao.getFavoriteList(id, category, pnum);
		
		int cnt = dao.getTotalCount(type);
		int start = pnum - ((pnum-1)%10);
		int end = (cnt-1)/15+1;
		
		ModelAndView mv = new ModelAndView("bbs.favoriteShops");
		
		mv.addObject("list", list);
		mv.addObject("p", pnum);
		mv.addObject("start", start);
		mv.addObject("end", end);
		
		return mv;
	}

}
