package cn.sinoutx.blog.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sinoutx.blog.model.entity.Artical;
import cn.sinoutx.blog.model.entity.Member;
import cn.sinoutx.blog.model.entity.Pager;
import cn.sinoutx.blog.model.mappers.ArticalMapper;

@Service
public class ArticalService {

	@Autowired
	private ArticalMapper articalMapper;
	
	/**
	 * 查询所有文章
	 * @return
	 */
	public List<Artical> findAll(Integer pager){
		/*String a="limit 0,8";
		if(pager!=null){*/
			
//		}
		
		List<Artical> ars = articalMapper.findAll(pager);
		
		return ars;
	}
	
	/**
	 * 计算总记录数
	 * @param id
	 * @return
	 */
	public Integer count(){
		
		return articalMapper.count();
	}
	/**
	 * 计算我的总记录
	 * @param id
	 * @return
	 */
public Integer countId(String id){
		
		return articalMapper.countId(id);
	}
	
	/**
	 * 增加一篇文章
	 * @param title
	 * @param main
	 * @param id
	 * @return
	 */
	public Integer addArtical(String title,String main,String id){
		
		return articalMapper.addArtical(title, main, id);
	}
	/**
	 * 个人文章
	 * @param pager
	 * @param artical_id
	 * @param id
	 * @return
	 */
public List<Artical> findAllById(String id,Integer pager){
		
		List<Artical> ars = articalMapper.findAllById(id,pager);
		
		return ars;
	}
	/**
	 * 根据文章id
	 * @param id
	 * @return
	 */
public Artical findAllByArticalId(String id){
	
	Artical ars = articalMapper.findAllByArticalId(id);
	
	return ars;
}

public Integer deleteId(String id){
	
	return articalMapper.deleteId(id);
}

/**
 * 根据姓名查找
 * @param name
 * @return
 */
public List<Member> findByMemberName(String name){
	
	return articalMapper.findByMemberName(name);
}

/**
 * 注册用户
 * @param name
 * @param password
 * @return
 */
public Integer addMember(String name,String password){
	
	return articalMapper.addMember(name, password);
}
}
