package cn.sinoutx.blog.tags;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import cn.sinoutx.blog.model.entity.Pager;




/**
 * 自定义分页标签
 * 
 * @author sin
 *
 */
public class PagerTag extends SimpleTagSupport {

	private String url;

	private Pager pager;

	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer sb = new StringBuffer();

		String params = this.bulidParams();

		sb.append("<div class=\"pager\">");

		if (pager.getPage() == 1) {
			sb.append("<a class=\"disable\">首页</a>");
			sb.append("<a class=\"disable\">上一页</a>");
		} else {
			sb.append(String.format("<a href=\"%s?page=1%s\">首页</a>", this.url, params));
			sb.append(String.format("<a href=\"%s?page=%s%s\">上一页</a>", this.url, this.pager.getPage() - 1, params));
		}

		if (pager.getPage() < pager.getTotalPage()) {
			sb.append(String.format("<a href=\"%s?page=%s%s\">下一页</a>", this.url, this.pager.getPage() + 1, params));
			sb.append(String.format("<a href=\"%s?page=%s%s\">尾页</a>", this.url, pager.getTotalPage(), params));
		} else {
			sb.append("<a class=\"disable\">下一页</a>");
			sb.append("<a class=\"disable\">尾页</a>");
		}

		sb.append(String.format("<span> %s/%s 总记录数：%s</span>", pager.getPage(), pager.getTotalPage(), pager.getTotal()));
		sb.append("</div>");

		// 输出到页面
		this.getJspContext().getOut().write(sb.toString());
	}

	/**
	 * 构建查询参数部分
	 * 
	 * @return "&mno=&uname=周&gender=";
	 * @throws UnsupportedEncodingException
	 */
	private String bulidParams() throws UnsupportedEncodingException {
		PageContext pageContext = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

		// 获取所有参数
		Map<String, String[]> paramsMap = request.getParameterMap();
		Set<Entry<String, String[]>> entrys = paramsMap.entrySet();

		StringBuffer sb = new StringBuffer();

		for (Entry<String, String[]> entry : entrys) {
			for (String value : entry.getValue()) {
				if (!"page".equalsIgnoreCase(entry.getKey()) && value != null && !value.isEmpty()) {
					sb.append(entry.getKey());
					sb.append("=");
					//编码参数值，保证在任何环境下，参数都不会乱码
					sb.append(URLEncoder.encode(value, "UTF-8"));
					sb.append("&");
				}
			}
		}

		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
			return "&" + sb.toString();
		}

		return "";
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
}
