package com.info.market.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.info.market.service.UserDetailsService;
import com.info.market.coding.ResultCodes;
import com.info.market.format.FormatDataUtil;
import com.info.market.model.UserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/test")
public class UserDetailController {
	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping("/showinputuserdetails")
	public void showInputUserDetails(ModelMap modelMap, String name, String description) {
		System.out.println("getURL");
		modelMap.put("userName", name);
		modelMap.put("userDescription", description);
	}
	@RequestMapping("/showuserdetails")
	public void showUserDetails(ModelMap modelMap){
		
	}
	@RequestMapping(value="/saveuserdetails", method=RequestMethod.GET)
	public String saveUserDetails(String name, String description) {
		userDetailsService.addUser(name, description);
		return "/test/showuserdetails";
	}
	@RequestMapping("/adduserdetails") 
	public String adduserDetails(String uname, String udescription){
		String resultMsg = userDetailsService.addUser(uname,udescription);
		String[] result = resultMsg.split(":");
		Map resultMap = new HashMap();
		if(result[0]==ResultCodes.SUCCESS){
			resultMap.put("success", true);
			resultMap.put("msg", result[1]);
		} else {
			resultMap.put("success", false);
			resultMap.put("msg", result[1]);
		}
		String resultJson = "";
		try {
			resultJson = new ObjectMapper().writeValueAsString(resultMap);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resultJson;
	}
	@RequestMapping("/testJsLoadup")
	public void testJsLoadup(ModelMap modelMap) {
		modelMap.put("jsID","ext-all");
		modelMap.put("jsName", "ext-all.js");
	}
	// ajax获取用户列表
	@RequestMapping("/getuserdetailslist")
	@ResponseBody
	public String getUserDetailsList(ModelMap modelMap) {
		List<UserDetails> userList = userDetailsService.getUserListWithoutOrderDetails();
		Map map = new HashedMap();
		map.put("userDetails", userList);
		map.put("userDetailsCount", userList.size());
		ObjectMapper om = new ObjectMapper();
		String result = "";
		try{
			result = om.writeValueAsString(map);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 获取去用户详细信息
	@RequestMapping("/getuserdetails")
	@ResponseBody
	public String getUserDeatails(String uid) {
		UserDetails ud = this.userDetailsService.getUserDetails(uid);
		ObjectMapper om = new ObjectMapper();
		String result = "";
		try{
			result = om.writeValueAsString(ud);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 显示单个用户详细信息
	@RequestMapping("/userdetailsview")
	public void userDetailsView(ModelMap modelMap, HttpServletResponse response, String uid) {
		response.setHeader("cust header", "this is customized header");
		UserDetails ud = this.userDetailsService.getUserDetails(uid);
		modelMap.put("details", ud);
	}
	
	//测试
	@RequestMapping("/pogba")
	public void showPogba(){
		
	}
}
