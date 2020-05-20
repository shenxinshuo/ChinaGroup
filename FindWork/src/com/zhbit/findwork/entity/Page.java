package com.zhbit.findwork.entity;
/**
 * 分页实体类
 * 
 * @author 王德略
 *
 */
public class Page {
	private int total;//总的数量
	private int maxSize;//每页最大数量
	private int current;//最近选择的页码
	private boolean haspre;//是否还有上一页
	private boolean hasnex;//是否还有下一页
	
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public int getTotal() {
		return total;
	}
	public boolean isHaspre() {
		return haspre;
	}
	public void setHaspre(boolean haspre) {
		this.haspre = haspre;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public boolean isHasnex() {
		return hasnex;
	}
	public void setHasnex(boolean hasnex) {
		this.hasnex = hasnex;
	}
	
}
