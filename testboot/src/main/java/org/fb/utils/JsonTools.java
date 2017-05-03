package org.fb.utils;

import com.google.gson.Gson;

/**
 * 
 * DateTime: 2017年4月27日下午9:46:47
 * 
 * @author wh
 * @Copyright (c) 2017, fb All Rights Reserved.
 **/
public class JsonTools {
	public static String beanToJson(Object obj){
		Gson gson = new Gson(); 
		return gson.toJson(obj);
	}
}
