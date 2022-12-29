package com.itheima.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;



public class DownloadUtils {
  public static String base64EncodeFileName(String fileName) {
		BASE64Encoder base64Encoder = new BASE64Encoder64();
		try {
			return "=?UTF-8?B?"
					+ new String(base64Encoder.encode(fileName
					.getBytes("UTF-8")))+"?=";
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	} 
/*	public static String getFileName(String agent,String filename) throws UnsupportedEncodingException {
		if(agent.contains("MISE")) {
			//IE浏览器
			filename = URLEncoder.encode(filename,"UTF-8");
			filename = filename.replace("+", " ");
		}else if(agent.contains("Firefox")) {
			//火狐浏览器
			filename ="=?UTF-8?B?" + Base64.getEncoder().encodeToString(filename.getBytes("UTF-8"))+"?=";
		}else {
			filename =URLEncoder.encode(filename,"UTF-8");
		}
		return filename;
	} */
	

}
