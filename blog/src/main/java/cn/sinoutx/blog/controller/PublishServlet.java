package cn.sinoutx.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sinoutx.blog.SpringTool;
import cn.sinoutx.blog.model.entity.Member;
import cn.sinoutx.blog.service.ArticalService;

/**
 * 发表文章
 */
@WebServlet("/publish")
public class PublishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticalService articalService;

    public PublishServlet() {
    	 articalService= SpringTool.getCtx().getBean(ArticalService.class);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/publish.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String artical_title = request.getParameter("title");
		String artical_main = request.getParameter("area2");
		HttpSession session = request.getSession();  
        Member m = (Member) session.getAttribute("user"); 
		String artical_user =m.getId().toString();

		if(artical_title==null){
			request.setAttribute("error", "标题不能为空");
			doGet(request, response);
			return;
		}else if(artical_main==null){
			request.setAttribute("error", "内容不能为空");
			doGet(request, response);
			return;
		}else{
		int row = articalService.addArtical(artical_title, artical_main, artical_user);
		if (row > 0) {
			response.sendRedirect("main");
		} else {
			request.setAttribute("error", "发表失败");
			doGet(request, response);
			return;
		}
		}
	}

}
