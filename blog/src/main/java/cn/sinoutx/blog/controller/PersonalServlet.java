package cn.sinoutx.blog.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sinoutx.blog.SpringTool;
import cn.sinoutx.blog.model.entity.Artical;
import cn.sinoutx.blog.model.entity.Member;
import cn.sinoutx.blog.model.entity.Pager;
import cn.sinoutx.blog.service.ArticalService;

/**
 * Servlet implementation class PersonalServlet
 */
@WebServlet("/personal")
public class PersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArticalService articalService;
	
	public PersonalServlet() {
		 articalService= SpringTool.getCtx().getBean(ArticalService.class);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strPage = request.getParameter("page");
		Integer str=0;
		if(strPage!=null){
			str = Integer.parseInt(strPage);
		}
		Pager pager = new Pager(strPage);
		String artical_id = request.getParameter("artical_id");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		Member user = (Member)session.getAttribute("user");
		String user_id =user.getId().toString();
		List<Artical> artical = articalService.findAllById(user_id,str);
		Integer total = articalService.countId(user_id);
		pager.setTotal(total);
		pager.setData(artical);
		// 将数据存入request作用域
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("/WEB-INF/jsp/personal.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
