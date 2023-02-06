package com.itheima.domain;

//jason返回数据
public class JsonResult {
	
	private int type;//0失败，1成功
	private String error;//错误信息
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
}
