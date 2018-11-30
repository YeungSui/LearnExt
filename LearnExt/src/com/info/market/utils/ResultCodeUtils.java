package com.info.market.utils;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class ResultCodeUtils {
	// 返回操作失败json字符串
	public static String opFailure(String e){
		return addAttribute("", "success", "false", false);
	}
	// 在json字符串中增加keyvalue项
	public static String addAttribute(String res, String key, String val, boolean isString){
		if (res == null)
			return res;
		if(isString) {
			val = "\""+val+"\"";
		}
		String newItem = key+":"+val;
		String result = "";
		if(!res.startsWith("{") || !res.endsWith("}")) {
			result = res;
		} 
		// 只有{}
		else if(res.length() == 2 ||  res.length() == 0) {
			return "{"+newItem+"}";
		}
		else {
			result = res.substring(1,res.length()-1);
		}
		return "{"+result+","+newItem+"}";
	}
}
