package com.info.market.service;

import java.util.List;

import com.info.market.dao.UserDetailsDao;
import com.info.market.format.FormatDataUtil;
import com.info.market.model.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class UserDetailsService {
	@Autowired
	private UserDetailsDao userDetailsDao;
	
	public void addUser(UserDetails ud) {
		System.out.println("生成的id值: "+userDetailsDao.addUserDetails(ud));
	}
	public List getUserList() {
		return userDetailsDao.getUserList();
	}
	public void addUser(String name, String description) {
		System.out.println("this is the test info of FormatDataUtil");
		System.out.println(FormatDataUtil.insertSpaceBeforeUpper(name));
	}
}
