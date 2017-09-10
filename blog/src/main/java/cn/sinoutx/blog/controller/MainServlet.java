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

import cn.sinoutx.blog.SpringTool;
import cn.sinoutx.blog.model.entity.Artical;
import cn.sinoutx.blog.model.entity.Pager;
import cn.sinoutx.blog.service.ArticalService;
import cn.sinoutx.blog.service.MemberService;



/**
 * 主页
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ArticalService articalService;
	
    public MainServlet() {
    	
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
		List<Artical> artical = articalService.findAll(str);
		Integer total = articalService.count();
		pager.setTotal(total);
		pager.setData(artical);
		// 将数据存入request作用域
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
