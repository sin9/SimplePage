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
import cn.sinoutx.blog.service.ArticalService;

/**
 * 删除
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ArticalService articalService;
	
	 public DeleteServlet() {
		 
		 articalService= SpringTool.getCtx().getBean(ArticalService.class);
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id =req.getParameter("id");
		if(id!=""){
		 int row = articalService.deleteId(id);
		 if(row>0){
			 resp.sendRedirect("personal");
		 }else{
			 resp.sendRedirect("personal");
		 }
		}else{
			resp.sendRedirect("personal");
		}
	}

	
	
}
