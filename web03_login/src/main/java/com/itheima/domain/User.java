package com.itheima.domain;
/**
 * 
 * @author jack
 *
 */
public class User {
	private Integer uid;
	private String username;
	private String password;
	private String nickname;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "User {uid=" + uid + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ "}";
	}
	
    
}
