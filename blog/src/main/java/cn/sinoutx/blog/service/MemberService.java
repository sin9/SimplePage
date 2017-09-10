package cn.sinoutx.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sinoutx.blog.model.entity.Member;
import cn.sinoutx.blog.model.mappers.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	private static MemberMapper memberMapper;
	
	/**
	 * 根据姓名查找
	 * @param name
	 * @return
	 */
	public Member findByMemberName(String name){
		
		return memberMapper.findByMemberName(name);
	}
	
	/**
	 * 注册用户
	 * @param name
	 * @param password
	 * @return
	 */
	public Integer addMember(String name,String password){
		
		return memberMapper.addMember(name, password);
	}
}
