package com.ltl.lesson;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "108758","514ac9da-bc28-4801-ac72-affb564194ce");
		
		 Map<String, Object> params = new HashMap<String, Object>();
		   params.put("number", "19914969259");
		   params.put("templateId", "4760");
		   String[] templateParams = new String[2];
		   templateParams[0] = "6666";
		   templateParams[1] = "5";
		   params.put("templateParams", templateParams);
		   try {
			String result = client.send(params);
			result = JSONObject.toJSONString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
