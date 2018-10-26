package com.info.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/market/info")
public class OrderInfoController {
	@RequestMapping("/createOrder")
	public void createOrder(ModelMap model) {
		
	}
}
