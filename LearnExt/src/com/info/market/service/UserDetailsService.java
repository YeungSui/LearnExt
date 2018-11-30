package com.info.market.service;

import java.math.BigDecimal;
import java.rmi.server.UID;
import java.sql.ResultSet;
import java.util.List;

import com.info.market.dao.UserDetailsDao;
import com.info.market.format.FormatDataUtil;
import com.info.market.model.*;
import com.sun.corba.se.spi.orb.StringPair;

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
	
	public BigDecimal addUser(UserDetails ud) {
		BigDecimal uid = userDetailsDao.addUserDetails(ud);
		System.out.println("新增用户id: "+uid);
		return uid;
	}
	public List getUserList() {
		return userDetailsDao.getUserList();
	}
	public List getUserListWithoutOrderDetails() {
		return userDetailsDao.getUserListWithoutOrderDetails();
	}
	public String addUser(String name, String description) {
		return "";
	}
	public UserDetails getUserDetails(String uid) {
		return userDetailsDao.getUserDetails(uid);
	}
}
