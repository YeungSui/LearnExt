package com.info.market.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * UserDetails entity. @author MyEclipse Persistence Tools
 */
@Cacheable(true)
@Entity
@Table(name = "USER_DETAILS", schema = "GGUSER")
public class UserDetails implements java.io.Serializable {

	// Fields

	private BigDecimal userId;
	private String userName;
	private String userDescription;
	private String userNationality;
	private String userSex;
	private String userJob;
	private Timestamp userBirthday;
	private BigDecimal userLevel;
	@JsonIgnore
	private Set<OrderDetails> orderDetailses = new HashSet<OrderDetails>(0);

	// Constructors

	/** default constructor */
	public UserDetails() {
	}

	/** minimal constructor */
	public UserDetails(BigDecimal userId, String userName,
			String userNationality) {
		this.userId = userId;
		this.userName = userName;
		this.userNationality = userNationality;
	}

	/** full constructor */
	public UserDetails(BigDecimal userId, String userName,
			String userDescription, String userNationality, String userSex,
			String userJob, Timestamp userBirthday, BigDecimal userLevel,
			Set<OrderDetails> orderDetailses) {
		this.userId = userId;
		this.userName = userName;
		this.userDescription = userDescription;
		this.userNationality = userNationality;
		this.userSex = userSex;
		this.userJob = userJob;
		this.userBirthday = userBirthday;
		this.userLevel = userLevel;
		this.orderDetailses = orderDetailses;
	}

	// Property accessors
	@Id
	@Column(name = "USER_ID", unique = true, nullable = false, precision = 38, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userGen")
	@SequenceGenerator(name="userGen", sequenceName="SEQ_USERDETAILS", allocationSize=1)	
	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	@Column(name = "USER_NAME", nullable = false, length = 256)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Lob
	@Column(name = "USER_DESCRIPTION")
	public String getUserDescription() {
		return this.userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	@Column(name = "USER_NATIONALITY", nullable = false, length = 256)
	public String getUserNationality() {
		return this.userNationality;
	}

	public void setUserNationality(String userNationality) {
		this.userNationality = userNationality;
	}

	@Column(name = "USER_SEX", length = 4)
	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	@Column(name = "USER_JOB", length = 512)
	public String getUserJob() {
		return this.userJob;
	}

	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}

	@Column(name = "USER_BIRTHDAY", length = 7)
	public Timestamp getUserBirthday() {
		return this.userBirthday;
	}

	public void setUserBirthday(Timestamp userBirthday) {
		this.userBirthday = userBirthday;
	}

	@Column(name = "USER_LEVEL", precision = 38, scale = 0)
	public BigDecimal getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(BigDecimal userLevel) {
		this.userLevel = userLevel;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userDetails")
	public Set<OrderDetails> getOrderDetailses() {
		return this.orderDetailses;
	}

	public void setOrderDetailses(Set<OrderDetails> orderDetailses) {
		this.orderDetailses = orderDetailses;
	}

}