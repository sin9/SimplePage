package cn.sinoutx.blog.model.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sinoutx.blog.model.entity.Artical;
import cn.sinoutx.blog.model.entity.Member;

public interface ArticalMapper {

	List<Artical> findAll(@Param("limit") Integer pagelimit);

	Integer count();
	
	Integer countId(@Param("id") String id);
	
	Integer addArtical(@Param("title") String title,
			@Param("main") String main,
			@Param("id") String id);
	
	List<Artical> findAllById(@Param("id") String id,@Param("limit") Integer pagelimit);
	
	Artical findAllByArticalId(@Param("artical_id") String aid);
	
	Integer deleteId(@Param("id") String id);
	
	List<Member> findByMemberName(@Param("name") String name);
	
	Integer addMember(@Param("name") String name,@Param("password") String password);
}
