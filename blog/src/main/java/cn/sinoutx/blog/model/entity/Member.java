package cn.sinoutx.blog.model.entity;

/**
 * 用户实体
 * 
 * @author sin
 *
 */
public class Member {

	private Long id;
	private String uname;
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", uname=" + uname + ", password=" + password + "]";
	}
}
