package com.zhbit.findwork.entity;

public class UserBirthday {

	private String byear;
	private String bmonth;
	private String bday;

	public String getByear() {
		return byear;
	}


	public void setByear(String byear) {
		this.byear = byear;
	}


	public String getBmonth() {
		return bmonth;
	}


	public void setBmonth(String bmonth) {
		this.bmonth = bmonth;
	}


	public String getBday() {
		return bday;
	}


	public void setBday(String bday) {
		this.bday = bday;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return byear+"-"+bmonth+"-"+bday;
	}
	
	
}
