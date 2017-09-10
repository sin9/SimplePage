package cn.sinoutx.blog.model.mappers;

import org.apache.ibatis.annotations.Param;

import cn.sinoutx.blog.model.entity.Member;

public interface MemberMapper {

	Member findByMemberName(@Param("name") String name);
	
	Integer addMember(@Param("name") String name,@Param("password") String password);
}
