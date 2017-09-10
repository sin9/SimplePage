package cn.sinoutx.blog;

import java.util.List;

import org.junit.Test;


import cn.sinoutx.blog.model.entity.Artical;
import cn.sinoutx.blog.model.entity.Member;
import cn.sinoutx.blog.service.ArticalService;
import cn.sinoutx.blog.service.MemberService;

public class Testp {

	@Test
	public void test1(){
		ArticalService as= SpringTool.getCtx().getBean(ArticalService.class);
		/*Artical a = as.findAllByArticalId("1");*/
//		Member a = as.findByMemberName("1");
		List<Artical> a = as.findAllById("1", 0);
		for (Artical artical : a) {
			
		System.out.println(artical);
		}
	
	}
	
	@Test
	public void test2(){
		MemberService as= SpringTool.getCtx().getBean(MemberService.class);
		Member a = as.findByMemberName("1");
		System.out.println(a);
	
	}
}
