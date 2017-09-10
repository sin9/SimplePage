package cn.sinoutx.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sinoutx.blog.SpringTool;
import cn.sinoutx.blog.service.ArticalService;
import cn.sinoutx.blog.service.MemberService;


/**
 * 注册
 */
@WebServlet("/register")
public class RegisterSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private MemberService memberService;
	private ArticalService articalService;
    public RegisterSevlet() {
    	/*memberService = SpringTool.getCtx().getBean(MemberService.class);*/
    	articalService = SpringTool.getCtx().getBean(ArticalService.class);
    }
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		String conpassword = req.getParameter("conpassword");
		if(conpassword.equals(password)){
			if (userName == null || userName.isEmpty()) {
				
				doGet(req, resp);
				return;
			}
			else if (password == null || password.isEmpty()) {
				
				doGet(req, resp);
				return;
			}
			else if (conpassword == null || conpassword.isEmpty()) {
				
				doGet(req, resp);
				return;
			}
			else{
				// 数据校验

				 int row= articalService.addMember(userName, password);
					// 判断是否有这个用户名的用户
					if (row!=1) {
						req.setAttribute("error", "注册失败");
						doGet(req, resp);
						return;
					}

					//重定向到注册成功页面
					resp.sendRedirect(req.getContextPath() +"/login");
			
			
			}
		}else{
			req.setAttribute("error", "两次密码输入必须一致");
			doGet(req, resp);
			return;
		}
	}

}
