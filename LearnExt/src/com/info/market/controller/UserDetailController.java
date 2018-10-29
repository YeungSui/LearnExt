package com.info.market.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.info.market.service.UserDetailsService;
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
		System.out.println("go into showuserdetails");
	}
	@RequestMapping(value="/saveuserdetails", method=RequestMethod.GET)
	public String saveUserDetails(String name, String description) {
		userDetailsService.addUser(name, description);
		return "/test/showuserdetails";
	}
	@RequestMapping("/testJsLoadup")
	public void testJsLoadup(ModelMap modelMap) {
		modelMap.put("jsID","ext-all");
		modelMap.put("jsName", "ext-all.js");
	}
	@RequestMapping("/getuserdetailslist")
	@ResponseBody
	public UserDetails getUserDetailsList() {
		System.out.println("go into getuserdetailslist");
		return new UserDetails();
	}
}
