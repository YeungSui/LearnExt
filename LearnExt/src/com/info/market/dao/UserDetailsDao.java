package com.info.market.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.info.market.model.GoodsDetails;
import com.info.market.model.OrderDetails;
import com.info.market.model.UserDetails;

@Repository
public class UserDetailsDao {
	
	private Configuration cfg = null;

	private SessionFactory sf = null;
	public UserDetailsDao() {
		cfg = new Configuration().addAnnotatedClass(UserDetails.class)
		.addAnnotatedClass(OrderDetails.class)
		.addAnnotatedClass(GoodsDetails.class)
		.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver")
		.setProperty("hibernate.connection.url","jdbc:oracle:thin:@localhost:1521:xe")
		.setProperty("hibernate.connection.username", "gguser")
		.setProperty("hibernate.connection.password", "hugo").
		setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect")
		.setProperty("hibernate.hbm2ddl.auto","update")
		.setProperty("hibernate.show_sql", "true");
		sf = cfg.buildSessionFactory();
	}
	// 获取用户列表
	public List getUserList() {
		Transaction trans = null;
		List<UserDetails> userList = null;
		try{
			Session session = sf.openSession();
			trans = session.beginTransaction();
			Query query = session.createQuery("from UserDetails order by uid desc");
			userList = query.list();
			trans.commit();
			session.close();
		} catch(Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return userList;
	}
	// 添加用户
	public String addUserDetails(UserDetails ud) {
		Transaction trans = null;
		String result = "";
		try {
			Session session = sf.openSession();
			trans = session.beginTransaction();
			Serializable id = session.save(ud);
			trans.commit();
			session.close();
			result = ((BigDecimal)id).toString();
		} catch(Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return result;
	}
}
