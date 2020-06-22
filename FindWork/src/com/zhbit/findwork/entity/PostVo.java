package com.zhbit.findwork.entity;

public class PostVo {

	private int id;
	private String pname;
	private String comment;
	private int ptid;
	
	public PostVo(String pname, String comment, int id, int ptid){
		this.pname = pname;
		this.comment = comment;
		this.id = id;
		this.ptid = ptid;
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

	public int getPtid() {
		return ptid;
	}

	public void setPtid(int ptid) {
		this.ptid = ptid;
	}
	
	
	
}
