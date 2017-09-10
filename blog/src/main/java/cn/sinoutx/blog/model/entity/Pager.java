package cn.sinoutx.blog.model.entity;

import java.util.List;

import com.mysql.jdbc.StringUtils;

/**
 * 分页数据对象
 * 
 * @author sin
 *
 */
public class Pager {

	/**
	 * 页大小，默认页大小为10条
	 */
	private int offset = 8;

	/**
	 * 当前页,默认为1
	 */
	private int page = 1;

	/**
	 * 总记录数
	 */
	private int total = 0;

	/**
	 * 总页数
	 */
	private int totalPage = 0;

	/**
	 * 当前页数据
	 */
	private List<?> data;

	public Pager() {
	}

	public Pager(int page) {
		this.setPage(page);
	}

	public Pager(String page) {
		this.setPage(page);
	}

	public Pager(int page, int offset) {
		this.setPage(page);
		this.offset = offset;
	}

	public Pager(String page, int offset) {
		this.setPage(page);
		this.offset = offset;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = Math.max(1, page);
	}

	public void setPage(String page) {
		if (!StringUtils.isNullOrEmpty(page)) {
			try {
				this.setPage(Integer.parseInt(page));
			} catch (Exception e) {
				System.out.println("页码错误!");
			}
		}
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		// 根据总记录数，求出总页数
		this.totalPage = (int) Math.ceil(total / ((double) offset));
	}

	public int getTotalPage() {
		return totalPage;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	/**
	 * 获取分页开始行数
	 * 
	 * @return
	 */
	public int getStart() {
		return (this.page - 1) * this.offset;
	}

	/**
	 * 分页参数
	 * @return
	 */
	public String getLimit() {
		return " limit " + this.getStart() + "," + this.offset;
	}

	@Override
	public String toString() {
		return "Pager [offset=" + offset + ", page=" + page + ", total=" + total + ", totalPage=" + totalPage + "]";
	}
}
