package com.zhbit.findwork.entity;

public class PostVo {

	private int id;
	private String pname;
	private String comment;
	
	public PostVo(String pname, String comment, int id){
		this.pname = pname;
		this.comment = comment;
		this.id = id;
	}
	
	public PostVo(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
