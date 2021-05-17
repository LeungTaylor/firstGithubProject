package com.ltl.lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Send {

	//SMS方法中有两个参数，这个参数是由前台页面提交的PostData和前者绑定的短信服务地址确定的

	public static String SMS(String postData, String postUrl) {
	try {
	//发送POST请求

	URL url = new URL(postUrl);

	HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	conn.setRequestMethod("POST");

	conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

	conn.setRequestProperty("Connection", "Keep-Alive");

	conn.setUseCaches(false);

	conn.setDoOutput(true);

	conn.setRequestProperty("Content-Length", "" + postData.length());

	OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");

	//将前台提交的数据放入输出流中，即向短信服务平台发送该条业务请求

	out.write(postData);

	out.flush();

	out.close();

	//获取响应状态码

	if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	System.out.println("connect failed!");

	return "";

	}

	//获取响应内容

	String line, result = "";

	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

	while ((line = in.readLine()) != null) {
	result += line + "\n";

	}

	in.close();

	return result;

	} catch (IOException e) {
	e.printStackTrace(System.out);

	}

	return "";

	}
	
}
