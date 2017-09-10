package cn.sinoutx.blog.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sinoutx.blog.SpringTool;
import cn.sinoutx.blog.model.entity.Artical;
import cn.sinoutx.blog.service.ArticalService;

/**
 * page
 */
@WebServlet("/page")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticalService articalService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
    	articalService= SpringTool.getCtx().getBean(ArticalService.class);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String artical_id=request.getParameter("artical");
		Artical artical = articalService.findAllByArticalId(artical_id);
		request.setAttribute("artical", artical);
		request.getRequestDispatcher("/WEB-INF/jsp/page.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
