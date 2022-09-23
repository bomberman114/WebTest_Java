package com.basic.user.vo;
//이것이 Vo다.

public class UserVo {
//Fields 전역변수의 자리다.
	private String useridx;
	private String userid;
	private String userpw;
	private String username;
	private String userindate;
	private String userupdate;
	private String userlogin;

//Constructor
	public UserVo() {
	}

	public UserVo(String useridx, String userid, String userpw, String username, String userindate, String userupdate,
			String userlogin) {
		super();
		this.useridx = useridx;
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userindate = userindate;
		this.userupdate = userupdate;
		this.userlogin = userlogin;
	}

// Getter Setter
	public String getUserid() {
		return userid;
	}

	public String getUseridx() {
		return useridx;
	}

	public void setUseridx(String useridx) {
		this.useridx = useridx;
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

	public Object getUserindate() {
		return userindate;
	}

	public void setUserindate(String userindate) {
		this.userindate = userindate;
	}

	public Object getUserupdate() {
		return userupdate;
	}

	public void setUserupdate(String userupdate) {
		this.userupdate = userupdate;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserlogin() {
		return userlogin;
	}

	public void setUserlogin(String userlogin) {
		this.userlogin = userlogin;
	}

//toString
	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", userindate="
				+ userindate + ", userupdate=" + userupdate + ", useridx=" + useridx + ", userlogin =" + userlogin
				+ "]";
	}

}
