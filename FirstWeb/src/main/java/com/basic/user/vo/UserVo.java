package com.basic.user.vo;
//이것이 Vo다.




public class UserVo {
//Fields 전역변수의 자리다.
	private String userid;
	private String userpw;
	private String username;

//Constructor
	public UserVo() {
	}

	public UserVo(String userid, String userpw, String username) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
	}

// Getter Setter
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//toString
	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", userpw=" + userpw + ", username=" + username + "]";
	}
	
	

}
