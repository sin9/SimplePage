package cn.sinoutx.blog;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sinoutx.blog.model.entity.Member;


/**
 * Servlet Filter implementation class CharacterEcodingFilter
 */
@WebFilter(dispatcherTypes = { 
		DispatcherType.REQUEST, 
		DispatcherType.FORWARD 
}, urlPatterns = { "/personal/*"})
public class Login2Filter implements Filter {

	/**
	 * Default constructor.
	 */
	public Login2Filter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		Member user = (Member)session.getAttribute("user");
		if(user == null){
			//未登录的情况下，重定向到登录界面
			resp.sendRedirect(req.getContextPath()+"/login");
		}else{
			//已经登录，不做任何事情了
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
