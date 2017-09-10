package cn.sinoutx.blog.model.entity;

public class Artical {
	private Long id;
	private String title;
	private String main;/*
	private String user_name;
	private Long user_id;*/
	public Member getUser() {
		return user;
	}
	public void setUser(Member user) {
		this.user = user;
	}
	private Member user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	/*public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}*/
	@Override
	public String toString() {
		return "Artical [id=" + id + ", title=" + title + ", main=" + main + "]";
	}

	
}
