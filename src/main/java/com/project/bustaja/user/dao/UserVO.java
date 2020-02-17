package com.project.bustaja.user.dao;

import java.io.Serializable;

public class UserVO implements Serializable{

	private String cid;
	private String cpw;
	private String cname;
	private String cphone;
	private int lev;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCpw() {
		return cpw;
	}
	public void setCpw(String cpw) {
		this.cpw = cpw;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	@Override
	public String toString() {
		return "UserVO [cid=" + cid + ", cpw=" + cpw + ", cname=" + cname + ", cphone=" + cphone + ", lev=" + lev + "]";
	}
	
	
	
}
