package cn.sinoutx.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginOutServlet
 */
@WebServlet("/logout")
public class LoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);//防止创建Session
		if(session == null){
		response.sendRedirect("/blog/main");
		return;
		}
		session.removeAttribute("user");
		response.sendRedirect("/blog/main");
	}

	
}
