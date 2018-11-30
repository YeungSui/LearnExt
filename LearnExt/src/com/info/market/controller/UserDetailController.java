package com.info.market.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.info.market.utils.ResultCodeUtils;
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
	@RequestMapping(value="/adduserdetails")
	public void saveUserDetails() {
		
	}
	/*
	 * 新增用户信息
	 */
	@RequestMapping("/saveuserdetails")
	@ResponseBody
	public String saveUserDetails(UserDetails userDetails){
		Map resMap = new HashMap();
		BigDecimal uid = new BigDecimal(-1);
		try{
			uid = this.userDetailsService.addUser(userDetails);
			System.out.println(userDetails.getUserNationality());
			System.out.println(userDetails.getUserDescription());
		} catch(Exception e) {
			return ResultCodeUtils.opFailure(e.getMessage());
		}
		resMap.put("success", "true");
		resMap.put("userId", uid);
		ObjectMapper om = new ObjectMapper();
		try{
			String res = om.writeValueAsString(resMap);
			return res;
		}
		catch(JsonProcessingException e){
			return ResultCodeUtils.opFailure(e.getMessage());
		}
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
			result = ResultCodeUtils.opFailure(e.getMessage());
		}
		return result;
	}
	
	// 获取用户详细信息
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
	public void userDetailsView(ModelMap modelMap, String uid) {
		UserDetails ud = this.userDetailsService.getUserDetails(uid);
		ObjectMapper om = new ObjectMapper();
		try {
			String result = om.writeValueAsString(ud);
			Map resMap = om.readValue(result, Map.class);
			modelMap.put("details", resMap);
		}
		catch(Exception e) {
			modelMap.put("details","");
		}
	}
}
