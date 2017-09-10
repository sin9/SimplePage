package cn.sinoutx.blog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTool {

	private static ApplicationContext ctx;
	
	static {
		ctx = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
	}
	
	public static ApplicationContext getCtx() {
		return ctx;
	}
}
