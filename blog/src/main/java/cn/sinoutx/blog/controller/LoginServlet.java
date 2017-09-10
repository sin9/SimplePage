package cn.sinoutx.blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sinoutx.blog.SpringTool;
import cn.sinoutx.blog.model.entity.Member;
import cn.sinoutx.blog.service.ArticalService;
import cn.sinoutx.blog.service.MemberService;



/**
 * 登录
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticalService articalService;
   
    public LoginServlet() {
    	articalService = SpringTool.getCtx().getBean(ArticalService.class);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	  private String res;
		/**
		 * 数据处理
		 */
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String username = req.getParameter("username");
		  String password = req.getParameter("password");
	        
				List<Member> ms = articalService.findByMemberName(username);
				
					Member m = new Member();
				
				if(username!=""&&password!=""&& !ms.isEmpty()){
					boolean s = false;
					for (Member member : ms) {
					s =member.getPassword().equals(password);
					if(s==true){
						m = member;
						break;
					}
					}
				if (s){
					req.getSession().setAttribute("user", m);
					resp.sendRedirect(req.getContextPath() +"/main");
				}
				
		        else{
		        	req.setAttribute("error", "用户名或密码错误！");
				doGet(req, resp);
				return;
		        }
				
				}
				else{
					req.setAttribute("error", "用户名或密码错误");
					doGet(req, resp);
					return;
				}
			
	        
	}

}
