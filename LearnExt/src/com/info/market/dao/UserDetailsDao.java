package com.info.market.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.info.market.coding.ResultCodes;
import com.info.market.format.FormatDataUtil;
import com.info.market.model.GoodsDetails;
import com.info.market.model.OrderDetails;
import com.info.market.model.UserDetails;
import com.info.market.service.UserDetailsService;
import com.sun.org.apache.bcel.internal.generic.Select;

@Repository
public class UserDetailsDao {
	
	@Autowired
	@Qualifier("entityManagerFactory")
	private EntityManagerFactory emFactory;
	@PersistenceContext
	private EntityManager em;
	
	/* 获取用户列表 */
	public List getUserList() {
		List<UserDetails> userList = null;
		try{
			Query query = em.createQuery("select u from UserDetails u order by uid desc", UserDetails.class);
			userList = query.getResultList();
			em.clear();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	/* 添加用户信息 */
	public BigDecimal addUserDetails(UserDetails ud) {
		BigDecimal result = null;
		try {
			em.persist(ud);
			em.flush();
			em.detach(ud);
			em.clear();
			result = ud.getUserId();
		} catch(Exception e) {
			e.printStackTrace();
			result = new BigDecimal(-1);
		}
		return result;
	}
	/* 自定义用户列表（指定返回字段）
	 * @param fields Specify fields to be obtained
	 * @return user list with specified fields
	 */
	/*private List getCustomizedUserList(String[] fields) {
		return (List<Object[]>)em.createQuery(FormatDataUtil.getSelectAllStatement(fields, "UserDetails")).getResultList();
	}*/
	/* 获取不包含订单信息的所有用户信息
	 * @return user list without order info
	 */
	public List getUserListWithoutOrderDetails() {
		List<UserDetails> userList = null;
		Query query = em.createQuery("select u from UserDetails u", UserDetails.class);
		userList = query.getResultList();
		em.clear();
		for (UserDetails user:userList){
			user.setOrderDetailses(null);
		}
		return userList;
	}
	public UserDetails getUserDetails(String uid) {
		System.out.println(uid);
		Query query = em.createQuery("select u from UserDetails u where u.userId="+uid, UserDetails.class);
		List<UserDetails> udList = query.getResultList();
		if (udList.size() > 0) {
			return udList.get(0);
		} else {
			return null;
		}
	}
}
